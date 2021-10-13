package com.martinezsoft.gotthat.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MongoDbSessionFactory {

    private String password;

    @Bean
    public MongoClient mongoClients(){
        password= GetPassword();
        return MongoClients.create("mongodb+srv://FrancoTMartinez:"+password+"@clustergotthatnote.9af9j.mongodb.net/GotThatNote-Notesdb?retryWrites=true&w=majority");
    }

    private String GetPassword(){
        StringBuilder sb = new StringBuilder();
        char[] chars= new char[13];

        chars[0] = (char) (523 * 223 - 116520);
        chars[1] = (char) (247 * 976 + 109 - 241070);
        chars[2] = (char) (898 * 874 + 103 - 784845);
        chars[3] = (char) (493 * 37 + 112 - 18256);
        chars[4] = (char) (675 * 819 + 108 - 552818);
        chars[5] = (char) (333 * 692 + 104 - 230424);
        chars[6] = (char) (593 * 694 + 98 - 411539);
        chars[7] = (char) (534 * 476 + 100 - 254170);
        chars[8] = (char) (607 * 336 + 122 - 203969);
        chars[9] = (char) (876 * 385 + 115 - 337264);
        chars[10] = ((char) 523 * 223) - 116573;
        chars[11] = ((char) 523 * 223) - 116577;
        chars[12] = ((char) 235 * 322) - 75614;
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
