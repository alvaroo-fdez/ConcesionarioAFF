package com.izv.aff.concesionario;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.util.Log;

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

    //region inicion conexion bd
    /**
     * REALIZANDO CONEXION CON LA BD
     */
    private static final String URL = "jdbc:mysql://146.59.237.189:3306/dam208_affconcesionario";
    private static final String USER = "dam208_aff";
    private static final String PASSWORD = "dam208_aff";
    public static ArrayList<Car> cars = new ArrayList<>() ;
    //region Metodo onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        obtainCars();
    }
    //endregion
    //endregion
    //region CREANDO Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //endregion
    //region OBTENCION DATOS DE LA BASE DE DATOS CONSULTA PARA OBTENER TODOS LOS carS
    public Connection conectoToTheDataBase() throws Exception {
        Connection cnn=null;
        StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(politica);
        Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        cnn = DriverManager.getConnection(URL,USER,PASSWORD);
        return cnn;

    }
    public void obtainCars(){
        try{
            Statement stm = conectoToTheDataBase().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM coches");
            while(rs.next()){
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
                car.setImagenes((rs.getString(12)));
                car.setPrecio(Integer.parseInt(rs.getString(13)));
                car.setLocalizacion(rs.getString(14));

                //Adding car to the arrayList
                cars.add(car);
                Log.v("adad",car.toString());

            }

        }catch(Exception e){
        }
    }

    //endregion
    //region FUNCIONALIDAD MENU
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
    //endregion
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}