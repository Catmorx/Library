package com.usa.library.service;

import com.usa.library.model.ReservationModel;
import com.usa.library.model.reports.ReportClient;
import com.usa.library.model.reports.ReportStatus;
import com.usa.library.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAllReservations() {
        return reservationRepository.getAllReservations();
    }

    public Optional<ReservationModel> getReservation(Integer idReservation) {
        return reservationRepository.getReservation(idReservation);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel) {
        return reservationRepository.saveReservation(reservationModel);
    }

    public boolean deleteReservation(Integer id) {
        try {
            reservationRepository.deleteReservation(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public ReservationModel updateReservation(ReservationModel reservationModel) {
        if (reservationModel.getIdReservation() != null) {
            Optional<ReservationModel> reservation = reservationRepository.getReservation( reservationModel.getIdReservation());
            if (!reservation.isEmpty()) {
                if (reservationModel.getStartDate() != null) {
                    reservation.get().setStartDate(reservationModel.getStartDate());
                }
                if (reservationModel.getDevolutionDate() != null) {
                    reservation.get().setDevolutionDate(reservationModel.getDevolutionDate());
                }
                if (reservationModel.getStatus() != null) {
                    reservation.get().setStatus(reservationModel.getStatus());
                }
                if (reservationModel.getLib() != null) {
                    reservation.get().setLib(reservationModel.getLib());
                }
                if (reservationModel.getClient() != null) {
                    reservation.get().setClient(reservationModel.getClient());
                }
                if (reservationModel.getScore() != null) {
                    reservation.get().setScore(reservationModel.getScore());
                }
                reservationRepository.updateReservation(reservation.get());
                return reservation.get();
            } else {
                return reservationModel;
            }
        } else {
            return reservationModel;
        }
    }
    public List<ReportClient> getTopClient(){
        return reservationRepository.getTopClient();
    }
    public ReportStatus getReportStatus(){
        List<ReservationModel> completed = reservationRepository.getReservationByStatus("completed");
        List<ReservationModel> cancelled=  reservationRepository.getReservationByStatus("cancelled");
//        ReportStatus num= new ReportStatus(completed.size(),cancelled.size());
        return new ReportStatus(completed.size(),cancelled.size());

    }
    public List<ReservationModel> getReservationPeriod(String date1, String date2){
        SimpleDateFormat parseDate = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate =  new Date();
        Date finishDate = new Date();
        try{
            startDate = parseDate.parse(date1);
            finishDate= parseDate.parse(date2);
        }catch (ParseException e){
            e.printStackTrace();
        }
        if (startDate.before(finishDate)) {
            return reservationRepository.getReservationPeriod(startDate,finishDate);
        }else{
            return new ArrayList<>();
        }
    }
}
