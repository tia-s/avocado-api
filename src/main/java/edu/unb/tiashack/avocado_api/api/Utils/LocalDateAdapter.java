// package edu.unb.tiashack.avocado_api.api.Utils;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import jakarta.xml.bind.annotation.adapters.XmlAdapter;

// public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
//     private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

//     @Override
//     public LocalDate unmarshal(String v) {
//         return LocalDate.parse(v, formatter);
//     }

//     @Override
//     public String marshal(LocalDate v) {
//         return v.format(formatter);
//     }
// }
