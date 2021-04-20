package br.com.alura.escolalura.infra.mongo.repositorys;

import br.com.alura.escolalura.dominio.Classificacao;
import br.com.alura.escolalura.dominio.models.Aluno;
import br.com.alura.escolalura.infra.mongo.codec.AlunoCodec;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AlunoDao implements AlunoRepository {

    private MongoClient mongoClient;
    private MongoDatabase database;

    @Override
    public Aluno salvar(Aluno aluno) {
        criaConexao();
        MongoCollection<Aluno> alunos = getCollection();

        if (aluno.getId() == null) alunos.insertOne(aluno);
        else alunos.updateOne(
                Filters.eq("_id", aluno.getId()),
                new Document("$set", aluno)
        );

        fechaConexao();
        return aluno;
    }

    @Override
    public List<Aluno> lista() {
        criaConexao();
        MongoCollection<Aluno> colecaoAlunos = getCollection();

        MongoCursor<Aluno> listaNoBanco = colecaoAlunos.find().iterator();
        List<Aluno> alunos = popularAlunos(listaNoBanco);

        fechaConexao();
        return alunos;
    }

    @Override
    public Optional<Aluno> buscaPorId(String id) {
        criaConexao();
        MongoCollection<Aluno> alunos = getCollection();
        Aluno aluno = alunos.find(Filters.eq("_id", new ObjectId(id))).first();
        Optional<Aluno> optionalAluno = Optional.of(aluno);
        return optionalAluno;
    }

    @Override
    public List<Aluno> buscaPorNome(String nome) {
        criaConexao();
        MongoCollection<Aluno> colecaoAlunos = getCollection();

        MongoCursor<Aluno> listaNoBanco = colecaoAlunos.find(Filters.eq("nome", nome), Aluno.class).iterator();
        List<Aluno> alunos = popularAlunos(listaNoBanco);

        fechaConexao();
        return alunos;
    }

    @Override
    public List<Aluno> buscaPor(Classificacao classificacao, double nota) {
        criaConexao();

        MongoCollection<Aluno> colecaoAlunos = getCollection();

        MongoCursor<Aluno> listaNoBanco = null;
        if (classificacao.equals(Classificacao.REPROVADOS)) {
            listaNoBanco = colecaoAlunos.find(Filters.lt("notas", nota)).iterator();
        } else if (classificacao.equals(Classificacao.APROVADOS)) {
            listaNoBanco = colecaoAlunos.find(Filters.gte("notas", nota)).iterator();
        }

        List<Aluno> alunos = popularAlunos(listaNoBanco);

        fechaConexao();
        return alunos;
    }

    private void criaConexao() {
        Codec<Document> codec = MongoClient.getDefaultCodecRegistry().get(Document.class);
        AlunoCodec alunoCodec = new AlunoCodec(codec);
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromCodecs(alunoCodec)
        );
        MongoClientOptions options = MongoClientOptions.builder().codecRegistry(codecRegistry).build();

        this.mongoClient = new MongoClient("localhost:27017", options);
        this.database = mongoClient.getDatabase("test");
    }

    private void fechaConexao() {
        this.mongoClient.close();
    }

    private MongoCollection<Aluno> getCollection() {
        return this.database.getCollection("alunos", Aluno.class);
    }

    private List<Aluno> popularAlunos(MongoCursor<Aluno> listaNoBanco) {
        List<Aluno> alunos = new ArrayList<>();
        while (listaNoBanco.hasNext()) {
            Aluno aluno = listaNoBanco.next();
            alunos.add(aluno);
        }
        return alunos;
    }
}
