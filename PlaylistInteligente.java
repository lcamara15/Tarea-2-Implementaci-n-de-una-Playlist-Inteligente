import java.util.*;

//Representa una canción con título y artista
class Cancion {
    private String titulo;
    private String artista;

    public Cancion(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }

    @Override
    public String toString() {
        return "[" + titulo + " - " + artista + "]";
    }
}

//Administra la playlist permitiendo agregar, eliminar, reproducir y ordenar canciones
class Playlist {
    private LinkedList<Cancion> canciones;

    public Playlist() {
        canciones = new LinkedList<>();
    }

    //Agrega una nueva canción a la playlist
    public void agregarCancion(String titulo, String artista) {
        canciones.add(new Cancion(titulo, artista));
        System.out.println("Canción agregada: " + titulo);
    }

    //Elimina una canción por título
    public void eliminarCancion(String titulo) {
        boolean removida = canciones.removeIf(c -> c.getTitulo().equalsIgnoreCase(titulo));
        if (removida) {
            System.out.println("Canción eliminada: " + titulo);
        } else {
            System.out.println("No se encontró la canción: " + titulo);
        }
        System.out.println();
    }

    //Reproduce y elimina la primera canción de la lista
    public void reproducirSiguiente() {
        if (!canciones.isEmpty()) {
            Cancion siguiente = canciones.removeFirst();
            System.out.println("Reproduciendo: " + siguiente);
        } else {
            System.out.println("La playlist está vacía.");
        }
        System.out.println();
    }

    //Ordena las canciones por artista
    public void ordenarPorArtista() {
        canciones.sort(Comparator.comparing(Cancion::getArtista));
        System.out.println("Playlist ordenada por artista.");
        System.out.println();
    }

    //Muestra la lista de canciones
    public void mostrarPlaylist() {
        if (canciones.isEmpty()) {
            System.out.println("La playlist está vacía.");
        } else {
            System.out.println("Playlist actual:");
            for (Cancion c : canciones) {
                System.out.println(c);
            }
        }
    }
}

//Prueba todas las funcionalidades de la playlist
public class PlaylistInteligente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist miPlaylist = new Playlist();

        System.out.println("Seleccione una opción de playlist:");
        System.out.println("1. Playlist: Neon Nostalgia");
        System.out.println("2. Playlist: Baladas & Desvelos");
        System.out.print("Ingrese su elección (1 o 2): ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        if (opcion == 1) {
            miPlaylist.agregarCancion("Anti-Hero", "Taylor Swift");
            miPlaylist.agregarCancion("Save Your Tears", "The Weeknd");
            miPlaylist.agregarCancion("Vampire", "Olivia Rodrigo");
            System.out.println();
        } else if (opcion == 2) {
            miPlaylist.agregarCancion("Hoy no me siento bien", "Alejandro Sanz, Grupo Frontera");
            miPlaylist.agregarCancion("Te Esperaba", "Carlos Rivera");
            miPlaylist.agregarCancion("Cómo te extraño mi amor", "Leo Dan");
            System.out.println();
        } else {
            System.out.println("Opción no válida. Saliendo del programa...");
            scanner.close();
            return;
        }

        //Mostrar playlist seleccionada
        miPlaylist.mostrarPlaylist();

        //Reproducir la siguiente canción
        miPlaylist.reproducirSiguiente();
        miPlaylist.mostrarPlaylist();

        //Eliminar una canción
        System.out.print("Ingrese el título de la canción a eliminar: ");
        String tituloEliminar = scanner.nextLine();
        miPlaylist.eliminarCancion(tituloEliminar);
        miPlaylist.mostrarPlaylist();

        //Ordenar por artista y mostrar
        miPlaylist.ordenarPorArtista();
        miPlaylist.mostrarPlaylist();

        scanner.close();
    }
}

