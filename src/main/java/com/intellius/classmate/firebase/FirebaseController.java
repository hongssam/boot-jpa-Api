package com.intellius.classmate.firebase;

import com.intellius.classmate.apiResponse.ApiResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firebase")
public class FirebaseController {
    @Autowired
    FirebaseCloudMessageService firebaseCloudMessageService;

    @RequestMapping(method = RequestMethod.GET, value = "/sendPush")
    public ResponseEntity<ApiResponseMessage> sendPush() throws Exception{
        String targetToken = "dyP9gRQ0SZW8dP0DoYLIxA:APA91bFqma5bmhCOU543c4U6n7G1DVUZ1vVck8dSofnlviws7_0uuF1lbZg90eypBjRy8EaOndAWqjanGuAIv3z3zNelAoAloV-fbImcHul-etBrQVtl8PCVK-pSLtYigR9D5uPmJXbR";
        String title = "푸쉬테스트";
        String body = "푸쉬테스트입니다";

        firebaseCloudMessageService.sendMessageTo(targetToken, title, body);
        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder().data("").message("push 발송 성공").build();

        return new ResponseEntity<>(apiResponseMessage, HttpStatus.OK);
    }
}
