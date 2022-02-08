package com.izv.aff.concesionario;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.izv.aff.concesionario.databinding.FragmentSecondBinding;
import com.izv.aff.concesionario.model.entity.Car;


import java.util.ArrayList;


public class SecondFragment extends Fragment {
    private Car car;
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Recogemos los datos fundamentales del ViewHolder
        Bundle bundle = new Bundle();
        bundle = getArguments();
        car = bundle.getParcelable("Concesionario");
        binding.tvTituloSec.setText(car.getTitulo());
        binding.tvReferencia2.setText(String.valueOf(car.getReference()));
        binding.tvPreciofinal.setText(car.getPrecio() + " €");
        binding.tvDescripcion.setText(car.getDescripcion());

        // Recogo los datos comprobando los huecos libres
        compruebaVacios();

        // Con un array guardo las fotos
        String[] imagenes = car.getArrayFotos();
        ArrayList<SlideModel> imgSlider = new ArrayList<>();
        // Voy recorriendo las fotos y las voy añadiendo al arrayList
        for (int i = 0; i < imagenes.length; i++) {
            imgSlider.add(new SlideModel(imagenes[i], ScaleTypes.CENTER_CROP));
            binding.imgCoche.setImageList(imgSlider);
        }

        binding.btCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Al darle al botón comprar nos llevará a su página de milanuncios
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(car.getUrl()));
                startActivity(intent);
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // Comprueba vacíos, para rellenar los huecos del segundo fragmento por si falta algún atributo del coche
    public void compruebaVacios() {
        if (car.getAno().equals("")) {
            binding.tvAnoSec.setText("Kilómetros: " + String.valueOf(car.getKm()) + " km");
            if ((char) car.getKm() == 0) {
                binding.tvAnoSec.setText("Potencia: " + String.valueOf(car.getPotencia()));
                if ((char) car.getPotencia() == 0) {
                    binding.tvAnoSec.setText("Combustible: " + car.getCombustible());
                    if (car.getCombustible().equals("")) {
                        binding.tvAnoSec.setText("Cambio: " + car.getCambio());
                        if (car.getCambio().equals("")) {
                            binding.tvAnoSec.setText("Nº Puertas: " + car.getNpuertas());
                            if ((char) car.getNpuertas() == 0) {
                                binding.tvAnoSec.setText("Color: " + car.getColor());
                                if (car.getColor().equals("")) {
                                    binding.tvAnoSec.setText("Localización: " + car.getLocalizacion());
                                }
                            }
                        }
                    }
                }
            }
        } else {
            binding.tvAnoSec.setText("Año: " + car.getAno());
        }

        if ((char) car.getKm() == 0) {
            binding.tvKmSec.setText("Potencia: " + String.valueOf(car.getPotencia()));
            if ((char) car.getPotencia() == 0) {
                binding.tvKmSec.setText("Combustible: " + car.getCombustible());
                if (car.getCombustible().equals("")) {
                    binding.tvKmSec.setText("Cambio: " + car.getCambio());
                    if (car.getCambio().equals("")) {
                        binding.tvKmSec.setText("Nº Puertas: " + car.getNpuertas());
                        if ((char) car.getNpuertas() == 0) {
                            binding.tvKmSec.setText("Color: " + car.getColor());
                            if (car.getColor().equals("")) {
                                binding.tvKmSec.setText("Localización: " + car.getLocalizacion());
                            }
                        }
                    }
                }
            }
        } else {
            binding.tvKmSec.setText("Kilómetros: " + String.valueOf(car.getKm()) + " km");
        }

        if ((char) car.getPotencia() == 0) {
            binding.tvPotenciaSec.setText("Combustible: " + car.getCombustible());
            if (car.getCombustible().equals("")) {
                binding.tvPotenciaSec.setText("Cambio: " + car.getCambio());
                if (car.getCambio().equals("")) {
                    binding.tvPotenciaSec.setText("Nº Puertas: " + car.getNpuertas());
                    if ((char) car.getNpuertas() == 0) {
                        binding.tvPotenciaSec.setText("Color: " + car.getColor());
                        if (car.getColor().equals("")) {
                            binding.tvPotenciaSec.setText("Localización: " + car.getLocalizacion());
                        }
                    }
                }
            }
        } else {
            binding.tvPotenciaSec.setText("Potencia: " + car.getPotencia() + " km");
        }

        if (car.getCombustible().equals("")) {
            binding.tvComb.setText("Cambio: " + car.getCambio());
            if (car.getCambio().equals("")) {
                binding.tvComb.setText("Nº Puertas: " + car.getNpuertas());
                if ((char) car.getNpuertas() == 0) {
                    binding.tvComb.setText("Color: " + car.getColor());
                    if (car.getColor().equals("")) {
                        binding.tvComb.setText("Localización: " + car.getLocalizacion());
                    }
                }
            }
        } else {
            binding.tvComb.setText("Combustible: " + car.getCombustible());
        }

        if (car.getCambio().equals("")) {
            binding.tvMarcha.setText("Nº Puertas: " + car.getNpuertas());
            if ((char) car.getNpuertas() == 0) {
                binding.tvMarcha.setText("Color: " + car.getColor());
                if (car.getColor().equals("")) {
                    binding.tvMarcha.setText("Localización: " + car.getLocalizacion());
                }
            }
        } else {
            binding.tvMarcha.setText("Cambio: " + car.getCambio());
        }

        if (car.getCambio().equals("")) {
            binding.tvMarcha.setText("Nº Puertas: " + car.getNpuertas());
            if ((char) car.getNpuertas() == 0) {
                binding.tvMarcha.setText("Color: " + car.getColor());
                if (car.getColor().equals("")) {
                    binding.tvMarcha.setText("Localización: " + car.getLocalizacion());
                }
            }
        } else {
            binding.tvMarcha.setText("Cambio: " + car.getCambio());
        }

        if ((char) car.getNpuertas() == 0) {
            binding.tvNPuertas.setText("Color: " + car.getColor());
            if (car.getColor().equals("")) {
                binding.tvNPuertas.setText("Localización: " + car.getLocalizacion());
            }
        } else {
            binding.tvNPuertas.setText("Nº Puertas: " + car.getNpuertas());
        }

        if (car.getColor().equals("")) {
            binding.tvColor.setText("Localización: " + car.getLocalizacion());
            binding.tvLocation.setText("");
        } else {
            binding.tvColor.setText("Color: " + car.getColor());
        }

        if (!car.getLocalizacion().equals("")) {
            binding.tvLocation.setText("");
        } else {
            binding.tvLocation.setText("Localización: " + car.getLocalizacion());
        }

    }

}