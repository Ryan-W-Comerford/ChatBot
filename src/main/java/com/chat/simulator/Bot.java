package com.chat.simulator;
import java.util.*;

class Bot implements User {
    private String name;
    public List<String> botHistory = new ArrayList<>();
    public HashMap<String, String[]> messageMap = new HashMap<>();

    @Override
    public String getName(){
        return name;
    }

     @Override
    public String sendChat(String humanMsg){
        String generatedMsg = generateBotMessage(humanMsg);

        System.out.println("Bot: " + generatedMsg);
        botHistory.add(generatedMsg);
        return generatedMsg;
    }

    public String generateBotMessage(String humanMsg){
        Random rand = new Random();
        String humanLoweCaseMsg = humanMsg.toLowerCase();

        for(int i = 0; i < humanLoweCaseMsg.length(); i++){
            for(int j = i + 1; j <= humanLoweCaseMsg.length(); j++){
                String checkSubstr = humanLoweCaseMsg.substring(i, j);
                if(messageMap.containsKey(checkSubstr)) {
                    String[] possible_responses = messageMap.get(checkSubstr);
                    int random_index = rand.nextInt(possible_responses.length);
                    return possible_responses[random_index];
                }
            }
        }
        String[] default_responses = messageMap.get("default");
        return default_responses[rand.nextInt(default_responses.length)];
    }

    public void setupResponses(){
        messageMap.put("hello", new String[]{"Hello! How's it going?", "Hello!!", "Hello!"});
        messageMap.put("hi", new String[]{"Hi! How's it going?", "Hi!!", "Hi!"});
        messageMap.put("hey", new String[]{"Hey! How's it going?", "Hey!!", "Hey!"});
        messageMap.put("thanks", new String[]{"You're welcome!", "Np! Let me know if anything else is needed!", "No problem!"});
        messageMap.put("what", new String[]{"Can you please clarify once more?", "Can you give more detail?"});
        messageMap.put("why", new String[]{"Let's try to answer that. Can you provide more details?", "Hmm not sure sorry!"});
        messageMap.put("how", new String[]{"I'll be happy to respond. Can you elaborate?", "Some things are just mysteries!"});
        messageMap.put("error", new String[]{"Oop let me try to see what went wrong.", "Sorry for the error!", "Let me try to fix what went wrong."});
        messageMap.put("help", new String[]{"What can I assist you with?", "Sure I can help!", "Can you provide details on what you need help with?"});
        messageMap.put("name", new String[]{"My name is Bot!", "My friends call me Bot!"});
        messageMap.put("exit", new String[]{"Goodbye!", "Bye!", "See you around!"});

        messageMap.put("?", new String[]{"Interesting Question!", "I often wonder that too!"});
        messageMap.put("!", new String[]{"Very Emphatic!", "I like the emphasis!"});

        messageMap.put("default", new String[]{"Great!", "I like this conversation!"});
    }
}