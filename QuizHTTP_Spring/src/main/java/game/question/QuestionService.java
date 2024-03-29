package game.question;

import game.deserializer.Deserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    // private final Client client = new Client("jservice.io", 80);
    private final QuestionRepository questionRepository;

    // todo: handle the Exception
    @Autowired
    public QuestionService(QuestionRepository questionRepository) throws IOException {
        this.questionRepository = questionRepository;
    }

    public ResponseEntity<List<QuestionResponse>> getNewQuestions(Integer num) throws IOException {
        List<QuestionResponse> response = new ArrayList<>();

        for (int i = 0; i < num; ++i) {
//            var questionString = client.getQuestion("/api/random?count=" + num);
//            var question = Deserializer.Deserialize(questionString, Question[].class)[0];
//            var savedQuestion = questionRepository.save(question);
//            response.add(new QuestionResponse(savedQuestion.getId(), savedQuestion.getQuestion()));
        }

        return ResponseEntity.ok(response);
    }
}
