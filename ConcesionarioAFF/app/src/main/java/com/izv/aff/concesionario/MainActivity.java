package com.izv.aff.concesionario;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.izv.aff.concesionario.databinding.ActivityMainBinding;
import com.izv.aff.concesionario.model.entity.Car;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    // Datos para la conexión con la Base de datos
    private static final String URL = "jdbc:mysql://146.59.237.189:3306/dam208_affconcesionario";
    private static final String USER = "dam208_aff";
    private static final String PASSWORD = "dam208_aff";
    public static ArrayList<Car> cars = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        cogerTodo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Hacemos la conexión para poder obtener los datos de la BBDD
    public Connection conectoToTheDataBase() throws Exception {
        Connection connection;
        StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(politica);
        Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;

    }

    public void cogerTodo() {
        try {
            Statement stm = conectoToTheDataBase().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM coches");
            while (rs.next()) {
                Car car = new Car();
                car.setReference(Integer.parseInt(rs.getString(1)));
                car.setCombustible(rs.getString(2));
                car.setKm(Integer.parseInt(rs.getString(3)));
                car.setCambio(rs.getString(4));
                car.setPotencia(Integer.parseInt(rs.getString(5)));
                car.setNpuertas(Integer.parseInt(rs.getString(6)));
                car.setColor(rs.getString(7));
                car.setAno(rs.getString(8));
                car.setTitulo(rs.getString(9));
                car.setDescripcion(rs.getString(10));
                car.setUrl(rs.getString(11));
                car.setImagenes(muestraImagen(rs.getString(12)));
                car.setArrayFotos(todasImg(rs.getString(12)));
                car.setPrecio(Integer.parseInt(rs.getString(13)));
                car.setLocalizacion(rs.getString(14));

                // Añado el coche al arraylist
                cars.add(car);

            }

        } catch (Exception e) {
        }
    }

    // Necesitamos obtener la primera imagen para mostrar del coche
    private String muestraImagen(String imagenes) {
        //Comprobación de error
        if (imagenes.isEmpty() || imagenes.length() <= 2) {
            return "https://static.turbosquid.com/Preview/2014/12/25__23_33_08/01.jpgc343e688-6e75-4628-90e0-b3331493f667Zoom.jpg";
        }

        //array
        String[] img;

        //Split
        img = imagenes.split(";");

        //Return primera foto
        return img[0];
    }

    // Obtenemos las imagenes
    private String[] todasImg(String imagenes) {
        String[] imgs;
        imgs = imagenes.split(";");
        return imgs;
    }

    // MENU
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.telefonoc:
                Toast.makeText(this, "Número de contacto: 555-765-123", Toast.LENGTH_LONG).show();
                return true;
            case R.id.correo:
                Toast.makeText(this, "Correo electrónico: afernandez1810@ieszaidinvergeles.org", Toast.LENGTH_LONG).show();
                return true;
            case R.id.redes:
                Toast.makeText(this, "Instagram: @alvarito_chulito | Twitter: @alvarote_chulote", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}