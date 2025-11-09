//package uz.ssh.springboottesting.service.TDLIB;
//
///**
// * @author Shokhimardon
// * @since 11/9/25
// */
//public class TelegramClient {
//    // Example: Creating a group with TDLib (using a Java wrapper)
//    public static void main(String[] args) {
//        // Initialize your TDLib client
//        TdApi.Client client = TdApi.Client.create(new UpdateHandler(), new ErrorHandler());
//
//        // Create a group (chat)
//        TdApi.CreateNewGroupChat createGroupRequest = new TdApi.CreateNewGroupChat();
//        createGroupRequest.title = "My New Group";
//        createGroupRequest.userIds = new long[]{userId1, userId2}; // Add user IDs here
//
//        // Send the request to create the group
//        client.send(createGroupRequest, new Client.ResultHandler() {
//            @Override
//            public void onResult(TdApi.Object object) {
//                if (object instanceof TdApi.Chat) {
//                    TdApi.Chat chat = (TdApi.Chat) object;
//                    System.out.println("Group created with ID: " + chat.id);
//                }
//            }
//
//            @Override
//            public void onError(TdApi.Error error) {
//                System.err.println("Error creating group: " + error.message);
//            }
//        });
//    }
//
//}
