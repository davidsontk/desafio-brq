package com.desafio.brq.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DateUtils {
    private static final String formatoData = "dd/MM/yyyy";
    private static final String formatoDataHora = "dd/MM/yyyy HH:mm:ss";

    public static Timestamp converterTimestampComPrimeiraHoraDia(String dataString) {
        return Optional.ofNullable(dataString)
                .map(str -> LocalDate.parse(dataString, DateTimeFormatter.ofPattern(formatoData)))
                .map(LocalDate::atStartOfDay)
                .map(Timestamp::valueOf)
                .orElse(null);
    }

    public static Timestamp getDataHoje() {
        return Timestamp.from(Instant.now());
    }




}
