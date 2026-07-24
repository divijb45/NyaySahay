package com.example.protestresources;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

public class MedicalVolunteerActivity extends AppCompatActivity {

    private LinearLayout medicalLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_volunteer);

        medicalLayout = findViewById(R.id.medicalLayout);

        addMedicalContact(
                "Chhatron Ki Goonj",
                "9827048238",
                "Emergency medical volunteer",
                "Delhi");

        addMedicalContact(
                "Chhatron Ki Goonj",
                "9211452848",
                "Emergency medical volunteer",
                "Delhi");

        addMedicalContact(
                "Chhatron Ki Goonj",
                "8826970690",
                "Emergency medical volunteer",
                "Delhi");

        addMedicalContact(
                "Anirudh Singh",
                "7338234381",
                "Orthopaedics Resident, IRPGI & NRCH",
                "New Delhi");

        addMedicalContact(
                "Anirudh Singh",
                "7895087922",
                "Orthopaedics Resident, IRPGI & NRCH",
                "New Delhi");

        addMedicalContact(
                "BodyTalks",
                "991198893",
                "24/7 post-injury rehab, physiotherapy, first aid and injury prevention",
                "Lajpat Nagar, Delhi");

        addMedicalContact(
                "Dr Shaurya Pratap",
                "7508009004",
                "Virtual consultations and prescriptions",
                "Delhi");

        addMedicalContact(
                "AAP Medical Helpline",
                "8588833548",
                "",
                "Delhi");

    }

    private void addMedicalContact(
            String name,
            String phone,
            String service,
            String location) {

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(32, 32, 32, 32);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        params.setMargins(0, 0, 0, 24);

        card.setLayoutParams(params);

        card.setBackgroundColor(android.graphics.Color.WHITE);

        TextView title = new TextView(this);
        title.setText(name);
        title.setTextSize(18);
        title.setTypeface(null, android.graphics.Typeface.BOLD);
        title.setTextColor(android.graphics.Color.parseColor("#212121"));

        TextView subtitle = new TextView(this);
        subtitle.setText(service);
        subtitle.setTextColor(android.graphics.Color.parseColor("#616161"));
        subtitle.setTextSize(15);

        TextView city = new TextView(this);
        city.setText("📍 " + location);
        city.setTextColor(android.graphics.Color.parseColor("#757575"));
        city.setTextSize(14);

        Button call = new Button(this);
        call.setText("📞 Call " + phone);
        call.setAllCaps(false);

        call.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phone));
            startActivity(intent);

        });

        card.addView(title);

        if (!service.isEmpty()) {
            card.addView(subtitle);
        }

        card.addView(city);
        card.addView(call);

        medicalLayout.addView(card);

    }

}