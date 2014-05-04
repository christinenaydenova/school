import java.io.IOException;
import java.net.ServerSocket;

public class TicTacToeServer {


	public static void main(String[] args) throws Exception {

		ServerSocket welcomeSocket = null;
		
			try {
				welcomeSocket = new ServerSocket(1234);         

				while(true){
				    ClientWorker w;
				    try{
				//server.accept returns a client connection
				      w = new ClientWorker(welcomeSocket.accept());
				      Thread t = new Thread(w);
				      t.start();
				    } catch (IOException e) {
				      System.out.println("Accept failed: 4444");
				      System.exit(-1);
				    }
				  }
				
			} catch(IOException e) {
				System.err.println("Could not listen on port.");
	            System.exit(1);
			}

			
			//Not sure if it's here
			try{
		        welcomeSocket.close();
		    } catch (IOException e) {
		        System.out.println("Could not close socket");
		        System.exit(-1);
		    }
			
	}
	
}