# uts_finabonacci

| Nama            | Rifa andiani meilawati yulianto |
| :--- | :--- |
|Nim              | 312210377
kelas            | TI22A4
Matakuliah       : PEMOGRAMAN MOBILE
Dosen pengampu  : Donny maulana,S.Kom.,M.Msi.

## Definisi Finabonacci

Sepertinya ada ketidaksesuaian dalam pertanyaan Anda. Mungkin yang dimaksud adalah "Fibonacci". Fibonacci merujuk pada serangkaian angka di mana setiap angka adalah hasil penjumlahan dari dua angka sebelumnya dalam deretan tersebut. Deret Fibonacci dimulai dengan 0 dan 1, kemudian angka berikutnya dihasilkan dengan menambahkan dua angka sebelumnya. Jadi, deret Fibonacci dimulai sebagai berikut: 0, 1, 1, 2, 3, 5, 8, 13, dan seterusnya.

Rumus umum untuk deret Fibonacci adalah \( F(n) = F(n-1) + F(n-2) \), di mana \( F(n) \) mewakili angka dalam deret tersebut, dan \( F(n-1) \) serta \( F(n-2) \) adalah dua angka sebelumnya.

Deret Fibonacci memiliki banyak aplikasi dalam matematika, ilmu komputer, seni, dan alam. Pola deret ini sering terlihat dalam struktur alami, seperti spiral bunga matahari, tata letak daun, dan lainnya.
<hr>

<h1 align="center">MainActivity.java</h1>

## Script

```java
package com.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView showCount;
    private int count = 0;
    private long fibNMinus1 = 0;
    private long fibNMinus2 = 1;
    private long currentfib= 0;
    private long limit = 0;
    private EditText edit_max_fibonacci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        showCount = findViewById(R.id.show_count);
        edit_max_fibonacci = findViewById(R.id.edit_max_fibonacci);

        updateCountDisplay();

    }

    private void updateCountDisplay() {
        showCount.setText(String.valueOf(fibNMinus1));

        if(count % 4 == 0) {
            showCount.setTextColor(getResources().getColor(R.color.colorPrimary));
        } else if (count % 4 == 1) {
            showCount.setTextColor(getResources().getColor(R.color.colorAccent));
        } else if (count % 4 == 2) {
            showCount.setTextColor(getResources().getColor(R.color.colorPrimary));
        } else {
            showCount.setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }
    public void showToast(View view) {
        Toast.makeText(this, "Bilangan Fibonacci",
                Toast.LENGTH_SHORT).show();
    }
    public void countUp(View view) {
        if(edit_max_fibonacci.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter limit first", Toast.LENGTH_SHORT).show();
            return;
        }
        limit = Long.parseLong(edit_max_fibonacci.getText().toString());
        if(count >= limit){
            Toast.makeText(this,"Fibonacci limit reached", Toast.LENGTH_SHORT).show();
            return;
        }
        long newFib = fibNMinus1 + fibNMinus2;
        fibNMinus2 = fibNMinus1;
        fibNMinus1 = newFib;
        currentfib = newFib;

        updateCountDisplay();
        count++;
    }

    public void back1(View view) {
        count = 0;
        fibNMinus1 = 0;
        fibNMinus2 = 1;
        currentfib = 0;
        updateCountDisplay();
    }

```
<h1 align="center">Android Manifest</h1>

Android manifest adalah file XML yang berisi informasi dasar tentang aplikasi Android, seperti nama aplikasi, versi, izin yang dibutuhkan, layanan yang disediakan, dan aktivitas yang dapat dijalankan oleh aplikasi.

## Script

```java
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Hello"
        tools:targetApi="31">

        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```
### String
String pada Android Studio adalah tipe data yang digunakan untuk menyimpan teks. String dapat digunakan untuk menyimpan teks apa pun, seperti nama, alamat, atau deskripsi. String direpresentasikan sebagai urutan karakter, dan dapat diakses menggunakan indeks.

# Script

```java
<resources>
    <string name="app_name">HelloAppTI22A4</string>
    <string name="button_label_toast">Toast</string>
    <string name="button_label_count">Count</string>
    <string name="count_initial_value">0</string>
    <string name="toast_message">Bilangan Fibonacci</string>
    <string name="button_label_finish">Back</string>
    <string name="enter_fibonacci_limit">Masukan limit angka</string>
    <string name="maximum_fibonacci">Enter Limit</string>
</resources>
```
### Colors
Colors pada Android Studio adalah kumpulan warna yang dapat digunakan di aplikasi Android. Colors direpresentasikan sebagai objek Color, yang dapat digunakan untuk menentukan warna teks, latar belakang, atau objek lainnya.

# Script
```java
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="white">#FFFFFFFF</color>
    <color name="biru">#0000FF</color>
    <color name="colorPrimary">#3F51B5</color>
    <color name="colorAccent">#FF4081</color>
    <color name="purple">#3F51B5</color>
    <color name="yellow">#FFFF00</color>
</resources>
```

## Activity Toast
Activity pada Android Studio adalah komponen yang menyediakan antarmuka pengguna (UI) untuk aplikasi. Activity adalah satu layar di aplikasi Android, dan setiap activity memiliki layout sendiri. Activity dapat berisi berbagai elemen UI, seperti tombol, teks, gambar, dan video. Activity adalah komponen penting dari aplikasi Android. Activity digunakan untuk menampilkan informasi kepada pengguna dan menerima input dari pengguna. Activity juga dapat digunakan untuk memulai aktivitas lain, menjalankan layanan, dan melakukan tugas-tugas lainnya.

# Script
```java
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.hello.MainActivity">
</androidx.constraintlayout.widget.ConstraintLayout>
```

### 1. Activity_Toast - Edit Text Limit Fibonacci
```java
<EditText
        android:id="@+id/edit_max_fibonacci"
        android:layout_width="190dp"
        android:layout_height="48dp"
        android:layout_marginStart="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginTop="8dp"
        android:minHeight="48dp"
        android:hint="@string/maximum_fibonacci"
        android:inputType="number"
        android:textColor="@android:color/white"
        android:background="@color/colorPrimaryDark"
        android:textAlignment="center"
        android:textColorHint="@android:color/white"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="MissingTranslation" />
```
#### 2. Activity_Toast - Button Toast
```java
<Button
        android:id="@+id/button_toast"
        android:layout_width="190dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:background="@color/colorPrimary"
        android:onClick="showToast"
        android:text="@string/button_label_toast"
        android:textColor="@android:color/white"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```
### 3. Activity_Toast = Button Count
```java
<Button
        android:id="@+id/button_count"
        android:layout_width="190dp"
        android:layout_height="48dp"
        android:layout_marginStart="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginBottom="8dp"
        android:background="@color/colorPrimary"
        android:onClick="countUp"
        android:text="@string/button_label_count"
        android:textColor="@android:color/white"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        tools:ignore="UsingOnClick, VisualLinButtonSize" />
```
### 4. Activity_Toast - Button Finish
```java
<Button
        android:id="@+id/button_finish"
        android:layout_width="190dp"
        android:layout_height="48dp"
        android:layout_marginStart="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginBottom="8dp"
        android:background="@color/colorPrimary"
        android:onClick="back1"
        android:text="@string/button_label_finish"
        android:textColor="@android:color/white"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent"
        tools:ignore="UsingOnClickInXml" />
```
### 5. Activity_Toast - Text View Show Count
```java
<TextView
        android:id="@+id/show_count"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginBottom="8dp"
        android:background="#FFFF00"
        android:gravity="center_vertical"
        android:text="@string/count_initial_value"
        android:textAlignment="center"
        android:textColor="@color/colorPrimary"
        android:textSize="160sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toTopOf="@+id/button_count"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button_toast"
        tools:ignore="RtlCompat"/>
```
## Output - Bilangan Fibonnaci
1. Memiliki perbedaan warna pada angka
2. Terdapat menu reset, menu count up, menu toast, dan menu limit



