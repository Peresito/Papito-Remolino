import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Bot {

	public static void main(String[] args) {
		String token="NzIzNDk2OTY1MjA3NDkwNTcw.Xuyh9Q.JSkH6W7XvDlWTjlGwgTHg6zTtsg";
		DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
		api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
            }
            if (event.getMessageContent().equalsIgnoreCase("!ip")) {
            	IP ip1=new IP();
            	try {
					String ip=ip1.getIp();
					event.getChannel().sendMessage(ip);
				} catch (Exception e) {
					event.getChannel().sendMessage("Error al obtener IP");
				}
            }
        });
	}

}
