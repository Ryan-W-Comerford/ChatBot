package com.chat.simulator;
import java.util.Scanner;

public class ChatSimulator {
    public static void main(String [] args){
        Human chatter = new Human();
        Bot bot = new Bot();

        bot.setupResponses();
        Scanner scanner = new Scanner(System.in);
        String humanMsg = "";
        
        System.out.println("Hi I'm A Bot! What's Up?");
        
        while(!humanMsg.equals("exit")){
            humanMsg = scanner.nextLine();
            chatter.sendChat(humanMsg);

            bot.sendChat(humanMsg);
        }

        System.out.println("Total Human Chats Sent :: " + chatter.humanHistory.size());
        System.out.println("Total Bot Chats Sent :: " + bot.botHistory.size());
    }
}