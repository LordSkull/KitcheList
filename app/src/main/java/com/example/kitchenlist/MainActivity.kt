package com.example.kitchenlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kitchenlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var FoodList = ArrayList<Food>()
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)


        FoodList = ArrayList()

        FoodList.add(Food(R.drawable.amatriciana, "Amatriciana",
            "Spaghetti o bucatini             320g\n" +
                    "Guanciale                       150g\n" +
                    "Pomodori pelati                400g\n" +
                    "Peperoncino (facoltativo)      1\n" +
                    "Pecorino romano grattugiato 50g\n" +
                    "Sale q.b.\n" +
                    "Pepe nero q.b.\n" +
                    "Olio extravergine d'oliva (facoltativo)",

            "Taglia il guanciale a striscioline o a cubetti.\n" +
                    "In una padella grande, preferibilmente di ferro, riscalda un filo d'olio extravergine d'oliva (opzionale) e aggiungi il guanciale. Fai rosolare a fuoco medio fino a quando il guanciale diventa dorato e croccante. Rimuovi il guanciale dalla padella e mettilo da parte, lasciando il grasso rilasciato in padella.\n" +
                    "Nella stessa padella con il grasso del guanciale, aggiungi il peperoncino sbriciolato (se usi) e i pomodori pelati schiacciati. Cuoci a fuoco medio-basso per circa 10-15 minuti, fino a quando la salsa si addensa. Aggiusta di sale se necessario (considera che il guanciale e il pecorino sono già saporiti).\n" +
                    "Nel frattempo, cuoci la pasta in abbondante acqua salata. Scolala al dente, tenendo da parte un po' di acqua di cottura.\n" +
                    "Aggiungi la pasta scolata direttamente nella padella con il sugo. Mescola bene per amalgamare, aggiungendo un po' di acqua di cottura se necessario per ottenere la giusta consistenza.\n" +
                    "Aggiungi il guanciale croccante messo da parte e mescola ancora.\n" +
                    "Spegni il fuoco e aggiungi il pecorino romano grattugiato. Mescola velocemente per distribuire il formaggio in modo uniforme.\n" +
                    "Servi immediatamente con una spolverata di pepe nero fresco."))


        FoodList.add(Food(R.drawable.carbonara, "Carbonara",
            "Spaghetti                     320g\n" +
                    "Gunciale                       150g\n" +
                    "Pecorino di Amatrice      100g\n" +
                    "Tuorli d'uovo                   4 \n" +
                    "Pepe nero q.b\n" +
                    "Sale q.b",
            "Taglia il guanciale a striscioline e fallo rosolare in una padella senza aggiungere olio fino a renderlo croccante. Metti da parte il guanciale e conserva il grasso rilasciato.\n" +
                    "Cuoci gli spaghetti in abbondante acqua salata.\n" +
                    "In una ciotola, sbatti i tuorli con il pecorino grattugiato e una generosa dose di pepe nero.\n" +
                    "Quando la pasta è al dente, scolala (conservando un po' di acqua di cottura) e versala nella padella con il grasso del guanciale. Mescola bene.\n" +
                    "Togli la padella dal fuoco e aggiungi il composto di tuorli e pecorino. Mescola rapidamente, aggiungendo un po' di acqua di cottura per ottenere una consistenza cremosa.\n" +
                    "Aggiungi il guanciale croccante, mescola e servi immediatamente con una spolverata di pecorino e pepe nero."))

        FoodList.add(Food(R.drawable.risotto_pescatore, "Risotto Alla Pescatora",
            "Riso            320g\n" +
                    "Cozze           300g\n" +
                    "Vongole         300g\n" +
                    "Calamari       200g\n" +
                    "Gamberi        200g\n" +
                    "Scampi         200g\n" +
                    "Brodo di pesce     1l\n" +
                    "Cipolle             1\n" +
                    "Spicchi d'aglio        2\n" +
                    "Pomodori pelati        200g\n" +
                    "Bicchiere di vino bianco secco     1\n" +
                    "Olio extravergine d'oliva q.b.\n" +
                    "Prezzemolo tritato q.b.\n" +
                    "Sale q.b.\n" +
                    "Pepe q.b.",
            "Pulisci bene le cozze e le vongole, eliminando le impurità. Fai aprire le cozze e le vongole in una padella a fuoco vivo con un filo d'olio e uno spicchio d'aglio. Filtra il liquido di cottura e mettilo da parte. Rimuovi la maggior parte dei molluschi dai gusci, lasciandone alcuni interi per decorare.\n" +
                    "Pulisci i calamari e tagliali a rondelle. Sguscia i gamberi e gli scampi, lasciandone qualcuno intero per decorare.\n" +
                    "In una pentola grande, soffriggi la cipolla tritata finemente con un filo d'olio. Aggiungi uno spicchio d'aglio e cuoci finché non è dorato, poi rimuovilo.\n" +
                    "Aggiungi i calamari e cuoci per qualche minuto. Aggiungi il riso e tostalo per un paio di minuti, mescolando continuamente.\n" +
                    "Sfuma con il vino bianco e lascia evaporare.\n" +
                    "Aggiungi i pomodori pelati schiacciati e mescola bene.\n" +
                    "Inizia ad aggiungere il brodo di pesce caldo, un mestolo alla volta, mescolando continuamente e aggiungendo altro brodo solo quando il precedente è stato assorbito.\n" +
                    "A metà cottura, aggiungi i gamberi e gli scampi. Continua a cuocere aggiungendo brodo.\n" +
                    "A cottura quasi ultimata, aggiungi le cozze e le vongole, insieme al loro liquido di cottura filtrato.\n" +
                    "Aggiusta di sale e pepe.\n" +
                    "Quando il riso è al dente e cremoso, spegni il fuoco e lascia riposare per un paio di minuti.\n" +
                    "Servi il risotto caldo, decorato con i molluschi interi e una spolverata di prezzemolo tritato."))

        FoodList.add(Food(R.drawable.pasta_patatejpg, "Pasta Con Patate",
            "Pasta corta (tubetti) 320g\n" +
                    "Patate                 500g\n" +
                    "Cipolla                 1\n" +
                    "Carota                    1\n" +
                    "Gambo di sedano        1\n" +
                    "Pomodori pelati        200g\n" +
                    "1 litro di brodo vegetale\n" +
                    "Olio extravergine d'oliva q.b.\n" +
                    "Sale q.b.\n" +
                    "Pepe q.b.\n" +
                    "Parmigiano Reggiano grattugiato (facoltativo)\n" +
                    "Prezzemolo tritato (facoltativo",
            "Pela le patate e tagliale a cubetti.\n" +
                    "In una pentola grande, soffriggi la cipolla tritata finemente con un filo d'olio. Aggiungi la carota e il sedano tritati e continua a soffriggere per qualche minuto.\n" +
                    "Aggiungi i pomodori pelati schiacciati e cuoci per 5-10 minuti.\n" +
                    "Unisci le patate a cubetti e copri con il brodo vegetale. Porta a ebollizione e lascia cuocere a fuoco lento per circa 20-30 minuti, finché le patate sono tenere.\n" +
                    "Aggiusta di sale e pepe.\n" +
                    "Aggiungi la pasta direttamente nella pentola con le patate e cuoci fino a quando la pasta è al dente, aggiungendo eventualmente un po' di acqua calda se il liquido si riduce troppo.\n" +
                    "Servi caldo, con una spolverata di parmigiano e prezzemolo tritato se lo desideri."))


        FoodList.add(Food(R.drawable.spaghettipomodoro, "Spaghetti Al Pomodoro",
            "Spaghetti                   320g\n" +
                    "Passata di pomodoro        700g\n" +
                    "Spicchi d'aglio                2\n" +
                    "Foglie di basilico fresco      5-6\n" +
                    "Olio extravergine d'oliva q.b.\n" +
                    "Sale q.b.\n" +
                    "Pepe q.b.\n" +
                    "Parmigiano Reggiano grattugiato (facoltativo)",
            "In una padella grande, riscalda un filo d'olio e aggiungi gli spicchi d'aglio schiacciati. Falli rosolare finché non diventano dorati, poi rimuovili.\n" +
                    "Aggiungi i pomodori pelati schiacciati o la passata di pomodoro. Cuoci a fuoco medio per circa 20-30 minuti, mescolando di tanto in tanto, fino a quando la salsa si addensa.\n" +
                    "Aggiusta di sale e pepe, e aggiungi le foglie di basilico spezzettate.\n" +
                    "Nel frattempo, cuoci gli spaghetti in abbondante acqua salata. Scolali al dente.\n" +
                    "Trasferisci gli spaghetti nella padella con la salsa di pomodoro e mescola bene per amalgamare.\n" +
                    "Servi caldo, con una spolverata di parmigiano se lo desideri."))

        FoodList.add(Food(R.drawable.pastagenovese, "Pasta Genovese",
            "Ziti               320g \n" +
                    "Cipolle dorate     1kg\n" +
                    "Carne di manzo      500g\n" +
                    "Pancetta           50g\n" +
                    "Carota                1\n" +
                    "Gambo di sedano       1\n" +
                    "Bicchiere di vino bianco secco     1\n" +
                    "Strutto o olio d'oliva     50g\n" +
                    "Sale e pepe q.b." +
                    "Sale fino q.b.",
            "Taglia le cipolle a fettine sottili, la carota e il sedano a pezzetti.\n" +
                    "In una pentola grande, fai sciogliere lo strutto (o riscalda l'olio) e aggiungi la pancetta tagliata a dadini.\n" +
                    "Aggiungi la carne di manzo tagliata a pezzi e falla rosolare bene su tutti i lati.\n" +
                    "Unisci le cipolle, la carota e il sedano e lascia cuocere a fuoco basso per almeno 2-3 ore, mescolando di tanto in tanto e aggiungendo un po' d'acqua se necessario. Le cipolle devono diventare una crema.\n" +
                    "Sfuma con il vino bianco e lascia evaporare.\n" +
                    "Aggiusta di sale e pepe.\n" +
                    "Cuoci la pasta in abbondante acqua salata, scolala al dente e condiscila con il sugo di cipolle e carne.\n" +
                    "Servi caldo, eventualmente con una spolverata di parmigiano grattugiato."))

        FoodList.add(Food(R.drawable.pastafagioli, "Pasta Fagioli",
            "Pasta (tubetti)       320g\n" +
                    "fagioli borlotti secchi       300G\n" +
                    "Cipolla        1\n" +
                    "Carota     1\n" +
                    "Gambo di sedano        1\n" +
                    "Spicchi d'aglio      2\n" +
                    "Rametto di rosmarino       1\n" +
                    "Foglie di alloro       2\n" +
                    "Pomodori pelati        200g\n" +
                    "Olio extravergine d'oliva q.b.\n" +
                    "Sale e pepe q.b.",
            "Se usi fagioli secchi, mettili a bagno in acqua fredda per una notte. Poi scolali e risciacquali.\n" +
                    "In una pentola capiente, soffriggi la cipolla, la carota, il sedano e l'aglio tritati con un po' d'olio.\n" +
                    "Aggiungi i fagioli (se secchi, scolati dall'acqua di ammollo) e copri con acqua fredda.\n" +
                    "Aggiungi il rosmarino e l'alloro, porta a ebollizione e lascia cuocere a fuoco lento per circa un'ora (30 minuti se usi fagioli già cotti).\n" +
                    "A metà cottura, aggiungi i pomodori pelati schiacciati e aggiusta di sale e pepe.\n" +
                    "Una volta che i fagioli sono cotti, togli il rosmarino e l'alloro e frulla una parte dei fagioli con un frullatore a immersione per ottenere una consistenza cremosa.\n" +
                    "Aggiungi la pasta e cuocila direttamente nella zuppa di fagioli, aggiungendo acqua calda se necessario.\n" +
                    "Quando la pasta è al dente, spegni il fuoco e lascia riposare per qualche minuto.\n" +
                    "Servi con un filo d'olio extravergine d'oliva a crudo e una spolverata di pepe."))

        FoodList.add(Food(R.drawable.tagliatelle_bolognese, "Tagliatelle alla bolognese",
            "Tagliatelle         400g\n" +
                    "Carne macinata mista  300g\n"+
                "Carota    1\n" +
                "Cipolla   1\n" +
                "Gambo di sedano  1\n" +
                "Passata di pomorodo   200g\n" +
                "Brodo di carne   200ml\n" +
                "Vino rosso secco    100ml\n" +
                "Cucchiai di concentrato di pomodoro    1\n" +
                "Latte intero    100ml\n" +
                "Olio extravergine d'oliva q.b.\n" +
                "Sale q.b.\n" +
                "Pepe q.b.\n",
            "Tritate finemente la carota, la cipolla e il sedano.\n" +
                    "In una casseruola, riscaldate un filo d'olio e aggiungete le verdure tritate. Soffriggete a fuoco medio-basso fino a quando le verdure sono morbide.\n" +
                    "Aggiungete la carne macinata e cuocete a fuoco medio-alto fino a quando non è ben rosolata. Sfumate con il vino rosso e lasciate evaporare.\n" +
                    "Aggiungete il concentrato di pomodoro e mescolate bene. Aggiungete poi la passata di pomodoro e il brodo di carne.\n" +
                    "Portate a ebollizione, poi riducete il fuoco al minimo e lasciate cuocere a fuoco lento per almeno 2 ore, mescolando di tanto in tanto. Aggiustate di sale e pepe.\n" +
                    "A fine cottura, aggiungete il latte per rendere il ragù più cremoso e cuocete per altri 10 minuti.\n" +
                    "Cuocete le tagliatelle in abbondante acqua salata, scolatele al dente e conditele con il ragù."))


        foodAdapter = FoodAdapter(FoodList)
        

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = foodAdapter

        foodAdapter.onItemClick = {
            val intent = Intent(this, DetailedFoodActivity::class.java)
            intent.putExtra("food", it)
            startActivity(intent)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterFoodList(newText)
                return true
            }
        })


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }


    private fun filterFoodList(text: String?) {
        val filteredList = ArrayList<Food>()
        if (text != null) {
            for (food in FoodList) {
                if (food.name.lowercase().contains(text.lowercase())) {
                    filteredList.add(food)
                }
            }
        } else {
            filteredList.addAll(FoodList)
        }
        foodAdapter.updateFoodList(filteredList)
    }

}
