package br.com.alura.escolalura.infra.mongo.codec;

import br.com.alura.escolalura.dominio.models.Aluno;
import br.com.alura.escolalura.dominio.models.Curso;
import br.com.alura.escolalura.dominio.models.Habilidade;
import br.com.alura.escolalura.dominio.models.Nota;
import org.bson.*;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlunoCodec implements CollectibleCodec<Aluno> {

    private Codec<Document> codec;

    public AlunoCodec(Codec<Document> codec) {
        this.codec = codec;
    }

    @Override
    public Aluno generateIdIfAbsentFromDocument(Aluno aluno) {
        return documentHasId(aluno) ? aluno.criarId() : aluno;
    }

    @Override
    public boolean documentHasId(Aluno aluno) {
        return aluno.getId() == null;
    }

    @Override
    public BsonValue getDocumentId(Aluno aluno) {
        if (!documentHasId(aluno)) {
            throw new IllegalStateException("Esse Document não tem id");
        }
        return new BsonString(aluno.getId().toHexString());
    }

    @Override
    public Aluno decode(BsonReader bsonReader, DecoderContext decoderContext) {
        Document document = codec.decode(bsonReader, decoderContext);

        Aluno aluno = new Aluno();
        aluno.setId(document.getObjectId("_id"));
        aluno.setNome(document.getString("nome"));
        aluno.setDataDeNascimento(document.getDate("data_nascimento"));

        Document curso = (Document) document.get("curso");
        if (curso != null) {
            String nomeCurso = curso.getString("nome");
            aluno.setCurso(new Curso(nomeCurso));
        }

        List<Double> notas = (List<Double>) document.get("notas");

        if (notas != null) {
            List<Nota> notasDoAluno = new ArrayList<>();
            notas.forEach(nota -> {
                notasDoAluno.add(new Nota(nota));
            });
            aluno.setNotas(notasDoAluno);
        }

        List<Document> habilidades = (List<Document>) document.get("habilidades");
        if (habilidades != null) {
            List<Habilidade> habilidadesDoAluno = new ArrayList<>();
            habilidades.forEach(habilidade -> {
                habilidadesDoAluno.add(
                        new Habilidade(habilidade.getString("nome"),
                                habilidade.getString("nivel"))
                );
            });
            aluno.setHabilidades(habilidadesDoAluno);
        }

        return aluno;
    }

    @Override
    public void encode(BsonWriter bsonWriter, Aluno aluno, EncoderContext encoderContext) {
        ObjectId id = aluno.getId();
        String nome = aluno.getNome();
        Date dataDeNascimento = aluno.getDataDeNascimento();
        Curso curso = aluno.getCurso();
        List<Habilidade> habilidades = aluno.getHabilidades();
        List<Nota> notas = aluno.getNotas();

        Document document = new Document();
        document.put("_id", id);
        document.put("nome", nome);
        document.put("data_nascimento", dataDeNascimento);
        document.put("curso", new Document("nome", curso.getNome()));

        if (habilidades != null) {
            List<Document> habilidadesDocument = new ArrayList<>();
            habilidades.forEach(habilidade -> {
                habilidadesDocument.add(new Document("nome", habilidade.getNome())
                        .append("nivel", habilidade.getNivel()));
            });
            document.put("habilidades", habilidadesDocument);
        }

        if (notas != null) {
            List<Double> notasDocument = new ArrayList<>();
            notas.forEach(nota -> {
                notasDocument.add(nota.getValor());
            });
            document.put("notas", notasDocument);
        }

        codec.encode(bsonWriter, document, encoderContext);
    }

    @Override
    public Class<Aluno> getEncoderClass() {
        return Aluno.class;
    }
}
