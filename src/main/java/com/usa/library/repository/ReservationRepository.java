package com.usa.library.repository;

import com.usa.library.model.ClientModel;
import com.usa.library.model.ReservationModel;
import com.usa.library.model.reports.ReportClient;
import com.usa.library.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<ReservationModel> getAllReservations() {
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }

    public Optional<ReservationModel> getReservation(Integer id) {
        return reservationCrudRepository.findById(id);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel) {
        return reservationCrudRepository.save(reservationModel);
    }

    public void deleteReservation(Integer id){
        reservationCrudRepository.deleteById(id);
    }
    public void updateReservation(ReservationModel reservationModel){
        reservationCrudRepository.save(reservationModel);
    }
    public List<ReservationModel> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    public List<ReservationModel> getReservationPeriod(Date startDate, Date finishDate){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(startDate, finishDate);
    }

    public List<ReportClient> getTopClient(){
        List<ReportClient> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countReservationModelByClient();
        for (Object[] i : report) {
            res.add(new ReportClient((Long) i[1], (ClientModel) i[0]));
        }
        return  res;
    }

}
