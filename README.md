# CurlViewPagerUI

ViewPager transisi Curl dengan menggunakan PageTransformer tanpa OpenGL yang bisa diterapkan di Expanded SystemUI

### Kode XML

Letakkan Kode XML ini di Expanded, sebagai contoh 5 halaman saja.

```
<com.mykodetutorial.curlviewpagerui.ViewPagerCurl android:id="@+id/id_viewpager_curl" android:layout_width="match_parent" android:layout_height="match_parent">
        <com.mykodetutorial.curlviewpagerui.HalamanCurlFrameLayout android:id="@+id/id_halaman_curl_1" android:layout_width="match_parent" android:layout_height="match_parent" android:orientation="vertical">
            <include layout="@layout/layout_halaman_curl_1"/>
        </com.mykodetutorial.curlviewpagerui.HalamanCurlFrameLayout>
        <com.mykodetutorial.curlviewpagerui.HalamanCurlFrameLayout android:id="@+id/id_halaman_curl_2" android:layout_width="match_parent" android:layout_height="match_parent" android:orientation="vertical">
            <include layout="@layout/layout_halaman_curl_2"/>
        </com.mykodetutorial.curlviewpagerui.HalamanCurlFrameLayout>
        <com.mykodetutorial.curlviewpagerui.HalamanCurlFrameLayout android:id="@+id/id_halaman_curl_3" android:layout_width="match_parent" android:layout_height="match_parent" android:orientation="vertical">
            <include layout="@layout/layout_halaman_curl_3"/>
        </com.mykodetutorial.curlviewpagerui.HalamanCurlFrameLayout>
        <com.mykodetutorial.curlviewpagerui.HalamanCurlFrameLayout android:id="@+id/id_halaman_curl_4" android:layout_width="match_parent" android:layout_height="match_parent" android:orientation="vertical">
            <include layout="@layout/layout_halaman_curl_4"/>
        </com.mykodetutorial.curlviewpagerui.HalamanCurlFrameLayout>
        <com.mykodetutorial.curlviewpagerui.HalamanCurlFrameLayout android:id="@+id/id_halaman_curl_5" android:layout_width="match_parent" android:layout_height="match_parent" android:orientation="vertical">
            <include layout="@layout/layout_halaman_curl_5"/>
        </com.mykodetutorial.curlviewpagerui.HalamanCurlFrameLayout>
    </com.mykodetutorial.curlviewpagerui.ViewPagerCurl>
```

### Penggunaan

Hal yang bisa diganti agar bisa menggunakan halamanmu sendiri.

Ganti kode berikut dengan kodemu sendiri

```
<com.mykodetutorial.curlviewpagerui.HalamanCurlFrameLayout android:id="@+id/id_halaman_curl_1" android:layout_width="match_parent" android:layout_height="match_parent" android:orientation="vertical">
  <!-- disini bisa apa saja -->
</com.mykodetutorial.curlviewpagerui.HalamanCurlFrameLayout>
```

dan lakukan juga sampai halaman 5

```
Selesai
```

## Authors

* **Suyonoion** - *ion* - [suyonoion](https://github.com/suyonoion)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Terimakasih

* Allah SWT
* AndroidStudio
* GitHub
* etc
