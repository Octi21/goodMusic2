package users;

import card.Card;
import playlist.Playlist;
import playlist.PlaylistService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientService {
        private ArrayList<Client> clients;

    public ClientService(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ClientService() {
        this.clients = new ArrayList<>();
    }

    public int getLastId(){
        int n = clients.size();
        if (n == 0)
            return 0;
        else
            return clients.get(n-1).getId();
//        int lastId = clients.get(n-1).getId();
//        return lastId;
    }

    public Client register()
    {
        Client.setAux(getLastId());
        Scanner scanner = new Scanner(System.in);
        System.out.println("first name: ");
        String fName = scanner.next();
        System.out.println("last name : ");
        String lName = scanner.next();
        System.out.println("email: ");
        String email = scanner.next();
        System.out.println("phone: ");
        String phone = scanner.next();
        System.out.println("username: ");
        String username = scanner.next();
        System.out.println("password: ");
        String password = scanner.next();

        Card card = new Card();
        Playlist playlist = new Playlist();

        Client client = new Client(fName,lName,email,phone,username,
                password,card,playlist);
        clients.add(client);

        ClientDao.getInstance().insert(client);
        return client;
    }

    public void createPlaylist(PlaylistService playlistService,
                               Client client)
    {
       Playlist playlist = playlistService.create(client.getId());
       client.setPlaylist(playlist);
    }



    public int login(String username, String password)
    {
        int ok = 0, ok2 = 0;
        for (Client elem: clients)
        {
            if (elem.getUsername().equals(username)  ||
                    elem.getEmail().equals(username))
            {
                ok +=1;
                if(elem.getPassword().equals(password))
                {
                    ok2 = 1;
//                    System.out.println("logged");
                    return elem.getId();
                }
            }
        }
        if(ok != 0)
            return -1;
        return 0;
    }



    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }
}
