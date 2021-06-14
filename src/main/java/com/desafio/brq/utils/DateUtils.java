package com.desafio.brq.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class DateUtils {
    private static final String formatoData = "dd/MM/yyyy";
    private static final String formatoDataHora = "dd/MM/yyyy HH:mm:ss";

    public static Timestamp converterTimestampComPrimeiraHoraDia(String dataString) {
        DateFormat format;
        try {
            format = new SimpleDateFormat(formatoDataHora);
            Date data = format.parse(dataString);
            return new Timestamp(data.getTime());
        } catch (ParseException e) {
            try {
                format = new SimpleDateFormat(formatoData);
                Date data = format.parse(dataString);
                return new Timestamp(data.getTime());
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            return null;
        }
    }

    public static Timestamp getDataHoje() {
        return Timestamp.from(Instant.now());
    }


}
