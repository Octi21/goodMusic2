package users;

import album.Album;
import album.AlbumDao;
import album.AlbumService;
import card.Card;
import card.CardService;
import playlist.Playlist;
import playlist.PlaylistService;
import song.Song;
import song.SongService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientService {
        private static ArrayList<Client> clients = new ArrayList<>();
        private static ClientService singelton = null;

    private ClientService() {
        clients = ClientDao.getInstance().getTable();
    }

    public static ClientService getInstance() {
        if( singelton == null)
        {
            singelton = new ClientService();
        }
        return singelton;
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

        Card card = CardService.getInstance().create(getLastId() + 1);
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

    public Client log()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("username/email: ");
        String username = scanner.next();
        System.out.print("password: ");
        String password = scanner.next();

        while (login(username,password) <= 0)
        {
            if(login(username,password) == -1)
                System.out.println("wrong password");
            else
                System.out.println("try again");
            System.out.print("username/email: ");
            username = scanner.next();
            System.out.print("password: ");
            password = scanner.next();
        }

        Client client = ClientDao.getInstance()
                .getById(login(username,password));
        System.out.println(client);
        return client;

    }

    public void playSong()
    {
        int i = 1;
        for(Song elem: SongService.getInstance().getSongs()){
            System.out.println(i + ". "+ elem.getName());
            i +=1;
        }
        Scanner scanner = new Scanner(System.in);
        int opt = scanner.nextInt();

        SongService.getInstance().listened(
                SongService.getInstance().getSongs().get(opt - 1).getId());


    }

    public void playAlbum()
    {
        int i = 1;
        for(Album elem: AlbumService.getInstance().getAlbums())
        {
            System.out.println(i + ". "+ elem.getName() +
                    " by " + elem.getArtistName());
            i += 1;
        }
        Scanner scanner = new Scanner(System.in);
        int opt = scanner.nextInt();

        AlbumService.getInstance().listened(
                AlbumService.getInstance().getLastId());

        AlbumService.getInstance().setAlbums(
                AlbumDao.getInstance().getAlbums());     // brute force update streams
    }




    public ArrayList<Client> getClients() {
        return clients;
    }

    public static void setClients(ArrayList<Client> clients)
    {
        ClientService.clients = clients;
    }
}
