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
import com.izv.aff.concesionario.databinding.FragmentSecondBinding;
import com.izv.aff.concesionario.model.entity.Car;

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
        //region Recogemos lo que se pasa del viewHolder
            Bundle bundle = new Bundle();
            bundle = getArguments();
            car = bundle.getParcelable("Concesionario");
            binding.tvTituloItem.setText(car.getTitulo());
            binding.tvAOItem.setText(car.getAno());
            binding.tvCambioItem.setText(car.getCambio());
            binding.tvCombustibleItem.setText(car.getCombustible());
            binding.tvKmItem.setText(String.valueOf(car.getKm()));
            binding.tvPotenciaItem.setText(String.valueOf(car.getPotencia()));
            binding.tvNumeroPuertasItem.setText(String.valueOf(car.getNpuertas()));
            binding.tvReferencia2.setText(String.valueOf(car.getReference()));
            binding.tvPujaminima.setText(String.valueOf(car.getPrecio()));
            binding.tvDescripcion.setText(car.getDescripcion());
            Glide.with(this).load(car.getImagenes()).into(binding.imgCoche);

            binding.btPujar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**
                     * Lo enviamos al anuncion para que lo compre
                     */
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(car.getUrl()));
                    startActivity(intent);
                }
            });
        //endregion

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}