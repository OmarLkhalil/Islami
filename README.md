# IslamiProject

Islami is a first project at Route it has ( quran - hadeth - tasbeh - radio ) .

## Clone

You can use the link from green button called code.
or you can just download it from here:

```bash
https://github.com/OmarLkhalil/RouteIslamiProject/archive/refs/heads/master.zip
```

## Project Description

 - It's a simple islamic application with simple 5 screens and navigation
 - Used (Fragments - Navigation - XML - Kotlin - resources - assets - splash)
 - Screen shots:
 ![alt text](https://github.com/OmarLkhalil/RouteIslamiProject/blob/master/Images/Screenshot%20(7).png)

## 6 steps to make this simple project: 
  - **First step**:
  
     start with importing our drawable files  
     1 - Splash Screen - 2 - background 3- icons 4 - Colors and themes. 
     ***we have dark and light them don't forget***
     
  - **Second step**: 
  
    <img src="https://github.com/OmarLkhalil/RouteIslamiProject/blob/master/Images/splash%403x.png" width="324" height="500">
1-  make our splash screen Activity and start with 
     layout and set background to the splashscreen res 
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout 
xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/splash"
    tools:context=".Activities.splash">
</androidx.constraintlayout.widget.ConstraintLayout>
```
   
   2- make the kotlin code in splashescreen Activity file:
    
```kotlin

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
 // we use Handler with this constructor (Looper.getMainLooper()) 
 // because the old Handler has been deprecated
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, Home::class.java))
            finish()
        }, 3000) // we set splash delay to 3 seconds then navigate to Home Screen
    }
}
```
3- now we make our AndroidManiFest.xml file and set IntentFiler to splash screen
 
```xml
       <activity
            android:name=".Activities.splash"
            android:exported="true"
            >
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />

            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
        </activity>
```

**Third step**: 

- is to make our home Activity 

1 - start with layout 
  
```xml
       <?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout 
xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/bg3"
    tools:context=".Activities.Home">


    <FrameLayout
        android:id="@+id/fragment_container"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toTopOf="@id/bottom_navigation"
        app:layout_constraintEnd_toEndOf="parent"
        >

    </FrameLayout>

    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottom_navigation"
        android:background="@color/gold"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintEnd_toEndOf="parent"
        app:menu="@menu/home_navigation" // the item menu is made there in res folder 
        app:itemTextColor="@color/bottom_navigation_icon_color"
        app:itemIconTint="@color/bottom_navigation_icon_color"
        />

</androidx.constraintlayout.widget.ConstraintLayout>
```

2- home.kt
```kotlin


lateinit var bottomNavigation : BottomNavigationView

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigation = findViewById(R.id.bottom_navigation) 

        bottomNavigation.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {
            menuItem ->

            if(menuItem.itemId == R.id.quran_navigation){
                pushFragment(QuranFragment())
            }
            else if (menuItem.itemId == R.id.hadeth_navigation){
                pushFragment(HadethFragment())
            }
            else if (menuItem.itemId == R.id.tasbeh_navigation){
                pushFragment(TasbehFragment())
            }
            else if (menuItem.itemId == R.id.radio_navigation){
                pushFragment(RadioFragment())
            }
            return@OnItemSelectedListener true
        })


        }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }
}


```
**Fourth step**:
 
 - Is to make our QuranFragment
 - 
<img src="https://github.com/OmarLkhalil/RouteIslamiProject/blob/master/Images/quran%403x.png" width="324" height="500">

1 - start with layout 
```xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/bg3">

    <TextView
        android:id="@+id/header_title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:paddingTop="10dp"
        android:text="إسلامي"
        android:textColor="@color/black"
        android:textSize="40sp"
        android:textStyle="bold"
        app:layout_constraintTop_toTopOf="parent">

    </TextView>

    <ImageView
        android:id="@+id/quran_logo"
        android:layout_width="409dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:src="@drawable/quranlogo"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@id/header_title">

    </ImageView>

    <View
        android:id="@+id/Top_Line"
        android:layout_width="match_parent"
        android:layout_height="3dp"
        android:background="@color/gold"
        app:layout_constraintTop_toBottomOf="@id/quran_logo">

    </View>


    <View
        android:id="@+id/bottom_Line"
        android:layout_width="match_parent"
        android:layout_height="3dp"
        android:layout_marginTop="56dp"
        android:background="@color/gold"
        app:layout_constraintTop_toBottomOf="@id/Top_Line"
        app:layout_constraintEnd_toEndOf="parent"
        tools:layout_editor_absoluteX="0dp">

    </View>


        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:paddingTop="10dp"
            android:text="اسم السورة"
            android:textColor="@color/black"
            android:textSize="30sp"
            android:textStyle="bold"
            app:layout_constraintTop_toBottomOf="@+id/Top_Line"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            >

        </TextView>

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/sura_rec"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
            android:layout_gravity="center"
            android:layout_marginTop="10dp"
            tools:listitem="@layout/sura_item"
            app:layout_constraintTop_toBottomOf="@+id/bottom_Line"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            >

        </androidx.recyclerview.widget.RecyclerView>


</androidx.constraintlayout.widget.ConstraintLayout>
```
 2- our item style in recyclerView: 

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <TextView
        android:id="@+id/header_title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:paddingTop="10dp"
        tools:text="البقرة"
        android:textColor="@color/black"
        android:textSize="30sp"
        android:textStyle="bold"
        >
    </TextView>

</FrameLayout>

```
3- let's make quran adapter for recyclerView: 
```kotlin
class quranAdapter (private val mList: List<String>) :
    RecyclerView.Adapter<quranAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sura_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suraName = mList.get(position)
        holder.textView.setText(suraName)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView : TextView = itemView.findViewById(R.id.header_title)
    }
}
```
4- now make the quranFragment code:

```kotlin
class QuranFragment : Fragment()  {

    val chaptersName = listOf(
        "الفاتحه","البقرة","آل عمران","النساء","المائدة","الأنعام","الأعراف","الأنفال","التوبة","يونس","هود"
        ,"يوسف","الرعد","إبراهيم","الحجر","النحل","الإسراء","الكهف","مريم","طه","الأنبياء","الحج","المؤمنون"
        ,"النّور","الفرقان","الشعراء","النّمل","القصص","العنكبوت","الرّوم","لقمان","السجدة","الأحزاب","سبأ"
        ,"فاطر","يس","الصافات","ص","الزمر","غافر","فصّلت","الشورى","الزخرف","الدّخان","الجاثية","الأحقاف"
        ,"محمد","الفتح","الحجرات","ق","الذاريات","الطور","النجم","القمر","الرحمن","الواقعة","الحديد","المجادلة"
        ,"الحشر","الممتحنة","الصف","الجمعة","المنافقون","التغابن","الطلاق","التحريم","الملك","القلم","الحاقة","المعارج"
        ,"نوح","الجن","المزّمّل","المدّثر","القيامة","الإنسان","المرسلات","النبأ","النازعات","عبس","التكوير","الإنفطار"
        ,"المطفّفين","الإنشقاق","البروج","الطارق","الأعلى","الغاشية","الفجر","البلد","الشمس","الليل","الضحى","الشرح"
        ,"التين","العلق","القدر","البينة","الزلزلة","العاديات","القارعة","التكاثر","العصر",
        "الهمزة","الفيل","قريش","الماعون","الكوثر","الكافرون","النصر","المسد","الإخلاص","الفلق","الناس"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_quran,
            container, false

        );
    }
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : quranAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.sura_rec)
        adapter = quranAdapter(chaptersName)
        recyclerView.adapter = adapter
    }
}
```
## My Social Accounts

<p align="left">
<a href="https://twitter.com/omartommm" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/twitter.svg" alt="omartommm" height="30" width="40" /></a>

<a href="https://discord.gg/LarryYu#2987" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/discord.svg" alt="LarryYu#2987" height="30" width="40" /></a>
</p>
