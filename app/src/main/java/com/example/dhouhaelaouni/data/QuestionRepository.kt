package com.example.dhouhaelaouni.data

import com.example.dhouhaelaouni.R

object QuestionRepository {

    val allQuestions: List<Question> = listOf(

        // ─── 🏛️ CATEGORY 1: ROMAN HERITAGE ─────────────────────────────
        Question(
            id = 1,
            imageRes = R.drawable.el_jem,
            options = listOf("Carthage", "El Jem", "Dougga", "Kairouan"),
            correctAnswerIndex = 1,
            category = Category.ROMAN,
            difficulty = Difficulty.EASY,
            funFact = "🏛️ El Jem is the 3rd largest Roman amphitheater in the world, built in the 3rd century AD!"
        ),
        Question(
            id = 2,
            imageRes = R.drawable.dougga,
            options = listOf("Dougga", "Sbeitla", "Bulla Regia", "Carthage"),
            correctAnswerIndex = 0,
            category = Category.ROMAN,
            difficulty = Difficulty.MEDIUM,
            funFact = "🏛️ Dougga is widely considered the best-preserved Roman small town in North Africa."
        ),
        Question(
            id = 3,
            imageRes = R.drawable.sbeitla,
            options = listOf("Sbeitla", "El Jem", "Tunis", "Monastir"),
            correctAnswerIndex = 0,
            category = Category.ROMAN,
            difficulty = Difficulty.EASY,
            funFact = "🏛️ Sbeitla (Sufetula) features a rare Capitol with three separate temples dedicated to Jupiter, Juno, and Minerva."
        ),
        Question(
            id = 4,
            imageRes = R.drawable.bulla_regia,
            options = listOf("Dougga", "Bulla Regia", "Kairouan", "Sfax"),
            correctAnswerIndex = 1,
            category = Category.ROMAN,
            difficulty = Difficulty.HARD,
            funFact = "🏛️ Bulla Regia is famous for its unique subterranean villas built to escape the intense summer heat."
        ),
        Question(
            id = 5,
            imageRes = R.drawable.thuburbo_majus,
            options = listOf("Dougga", "Sbeitla", "Bizerte", "Thuburbo Majus"),
            correctAnswerIndex = 3,
            category = Category.ROMAN,
            difficulty = Difficulty.HARD,
            funFact = "🏛️ Thuburbo Majus was originally a Punic town that was elevated to a Roman colony under emperor Commodus."
        ),
        Question(
            id = 6,
            imageRes = R.drawable.pupput,
            options = listOf("Pupput", "Carthage", "El Jem", "Tozeur"),
            correctAnswerIndex = 0,
            category = Category.ROMAN,
            difficulty = Difficulty.MEDIUM,
            funFact = "🏛️ Pupput, located near modern Hammamet, is known for its remarkable collection of Roman mosaics."
        ),
        Question(
            id = 7,
            imageRes = R.drawable.maktar,
            options = listOf("Sbeitla", "Maktar", "Dougga", "Tunis"),
            correctAnswerIndex = 1,
            category = Category.ROMAN,
            difficulty = Difficulty.HARD,
            funFact = "🏛️ Maktar (Mactaris) was established by Numidians and later Romanized, featuring impressive baths and an amphitheater."
        ),
        Question(
            id = 8,
            imageRes = R.drawable.utica,
            options = listOf("Carthage", "Sfax", "Utica", "Kairouan"),
            correctAnswerIndex = 2,
            category = Category.ROMAN,
            difficulty = Difficulty.MEDIUM,
            funFact = "🏛️ Utica was the first Roman capital of the province of Africa before Carthage was rebuilt."
        ),
        Question(
            id = 9,
            imageRes = R.drawable.haidra,
            options = listOf("Haidra", "Dougga", "El Jem", "Tunis"),
            correctAnswerIndex = 0,
            category = Category.ROMAN,
            difficulty = Difficulty.HARD,
            funFact = "🏛️ Haidra (Ammaedara) was one of the oldest Roman settlements in Africa, housing the Third Augustan Legion."
        ),
        Question(
            id = 10,
            imageRes = R.drawable.meninx,
            options = listOf("Djerba", "Meninx", "Carthage", "Bizerte"),
            correctAnswerIndex = 1,
            category = Category.ROMAN,
            difficulty = Difficulty.HARD,
            funFact = "🏛️ Meninx, located on the island of Djerba, was a major Roman center for producing precious purple dye."
        ),
        // ─── 🕌 CATEGORY 2: ISLAMIC HERITAGE ───────────────────────────
        Question(
            id = 11,
            imageRes = R.drawable.mosque_kairouan,
            options = listOf("Kairouan", "Tunis", "Sousse", "Sfax"),
            correctAnswerIndex = 0,
            category = Category.ISLAMIC,
            difficulty = Difficulty.EASY,
            funFact = "The Great Mosque of Kairouan is one of the most important Islamic monuments in North Africa, founded in 670 AD."
        ),
        Question(
            id = 12,
            imageRes = R.drawable.zitouna,
            options = listOf("Kairouan", "Monastir", "Zitouna", "Mahdia"),
            correctAnswerIndex = 2,
            category = Category.ISLAMIC,
            difficulty = Difficulty.EASY,
            funFact = " The Zitouna Mosque in Tunis is the oldest in the capital and once hosted one of history's greatest universities."
        ),
        Question(
            id = 13,
            imageRes = R.drawable.ribat_monastir,
            options = listOf("Mahdia", "Monastir", "Sousse", "Tunis"),
            correctAnswerIndex = 1,
            category = Category.ISLAMIC,
            difficulty = Difficulty.MEDIUM,
            funFact = " The Ribat of Monastir is an imposing Islamic defensive structure that has been used as a set for many famous movies."
        ),
        Question(
            id = 14,
            imageRes = R.drawable.mahdiya_mosque,
            options = listOf("Sfax", "Tunis", "Kairouan", "Mahdia"),
            correctAnswerIndex = 3,
            category = Category.ISLAMIC,
            difficulty = Difficulty.MEDIUM,
            funFact = " The Great Mosque of Mahdia has a unique un-minareted entrance resembling a Roman triumphal arch."
        ),
        Question(
            id = 15,
            imageRes = R.drawable.tunis_medina,
            options = listOf("Sousse", "Tunis", "Kairouan", "Sfax"),
            correctAnswerIndex = 1,
            category = Category.ISLAMIC,
            difficulty = Difficulty.EASY,
            funFact = " The Medina of Tunis contains over 700 historic monuments, palaces, and mosques."
        ),
        Question(
            id = 16,
            imageRes = R.drawable.kairouan_city,
            options = listOf("Tunis", "Monastir", "Kairouan", "Sfax"),
            correctAnswerIndex = 2,
            category = Category.ISLAMIC,
            difficulty = Difficulty.EASY,
            funFact = " The Kairouan Medina is famous for its narrow alleys, white-washed walls, and vibrant carpet shops."
        ),
        Question(
            id = 17,
            imageRes = R.drawable.kasbah_tunis,
            options = listOf("Sousse", "Kairouan", "Tunis", "Bizerte"),
            correctAnswerIndex = 2,
            category = Category.ISLAMIC,
            difficulty = Difficulty.HARD,
            funFact = " The Kasbah Mosque in Tunis features a distinct square Almohad-style minaret."
        ),
        Question(
            id = 18,
            imageRes = R.drawable.hammouda_pacha,
            options = listOf("Kairouan", "Sfax", "Gabes", "Tunis"),
            correctAnswerIndex = 3,
            category = Category.ISLAMIC,
            difficulty = Difficulty.HARD,
            funFact = " The Hammouda Pacha Mosque in Tunis is renowned for its beautiful octagonal Turkish-style minaret."
        ),
        Question(
            id = 19,
            imageRes = R.drawable.zaouia_sidi_sahbi,
            options = listOf("Kairouan", "Tunis", "Sousse", "Mahdia"),
            correctAnswerIndex = 0,
            category = Category.ISLAMIC,
            difficulty = Difficulty.MEDIUM,
            funFact = " Commonly known as the Mosque of the Barber, it houses the tomb of Abu Zama' al-Balawi, a companion of the Prophet."
        ),

        Question(
            id = 20,
            imageRes = R.drawable.mosque_testour,
            options = listOf("Tunis", "Sousse", "Testour", "Kairouan"),
            correctAnswerIndex = 2,
            category = Category.ISLAMIC,
            difficulty = Difficulty.MEDIUM,
            funFact = " Testour's Great Mosque exhibits strong Andalusian influence, featuring a unique minaret with a clock that runs counterclockwise!"
        ),

        // ─── 🏺 CATEGORY 3: PUNIC & PRE-ROMAN ──────────────────────────
        Question(
            id = 21,
            imageRes = R.drawable.img,
            options = listOf("Utica", "Kerkouane", "Carthage", "Hadrumetum"),
            correctAnswerIndex = 2,
            category = Category.PUNIC,
            difficulty = Difficulty.EASY,
            funFact = " The Punic military port of Carthage was circular and could secretly house up to 220 warships."
        ),
        Question(
            id = 22,
            imageRes = R.drawable.img,
            options = listOf("Carthage", "Tophet", "Dougga", "Bulla Regia"),
            correctAnswerIndex = 0,
            category = Category.PUNIC,
            difficulty = Difficulty.MEDIUM,
            funFact = " Byrsa Hill was the walled citadel of ancient Carthage, famously defended during the Third Punic War."
        ),
        Question(
            id = 23,
            imageRes =R.drawable.img,
            options = listOf("Utica", "Carthage", "Kerkouane", "Dougga"),
            correctAnswerIndex = 1,
            category = Category.PUNIC,
            difficulty = Difficulty.HARD,
            funFact = " The Tophet was a sacred Punic precinct dedicated to the deities Baal Hammon and Tanit."
        ),
        Question(
            id = 24,
            imageRes = R.drawable.img,
            options = listOf("Tunis", "Bizerte", "Nabeul", "Sousse"),
            correctAnswerIndex = 2,
            category = Category.PUNIC,
            difficulty = Difficulty.MEDIUM,
            funFact = " Kerkouane is the only surviving purely Punic city, abandoned and never rebuilt by the Romans!"
        ),
        Question(
            id = 25,
            imageRes = R.drawable.img,
            options = listOf("Bizerte", "Carthage", "Nabeul", "Sfax"),
            correctAnswerIndex = 0,
            category = Category.PUNIC,
            difficulty = Difficulty.MEDIUM,
            funFact = " Utica was founded by Phoenicians around 1100 BC, making it traditionally older than Carthage."
        ),
        Question(
            id = 26,
            imageRes = R.drawable.img,
            options = listOf("Beja", "Jendouba", "Kef", "Siliana"),
            correctAnswerIndex = 0,
            category = Category.PUNIC,
            difficulty = Difficulty.HARD,
            funFact = " Before the Romans, Dougga was an important capital for the indigenous Numidian kings."
        ),
        Question(
            id = 27,
            imageRes = R.drawable.img,
            options = listOf("Beja", "Jendouba", "Kef", "Bizerte"),
            correctAnswerIndex = 1,
            category = Category.PUNIC,
            difficulty = Difficulty.MEDIUM,
            funFact = " Bulla Regia served as a Numidian royal residence before falling under Roman control."
        ),
        Question(
            id = 28,
            imageRes = R.drawable.img,
            options = listOf("Dougga", "Carthage", "Utica", "Kerkouane"),
            correctAnswerIndex = 0,
            category = Category.PUNIC,
            difficulty = Difficulty.HARD,
            funFact = " The Mausoleum of Ateban at Thugga (Dougga) is a rare intact example of Numidian royal architecture."
        ),
        Question(
            id = 29,
            imageRes =R.drawable.img,
            options = listOf("Bizerte", "Sousse", "Tunis", "Gabes"),
            correctAnswerIndex = 0,
            category = Category.PUNIC,
            difficulty = Difficulty.HARD,
            funFact = " Hippo Diarrhytus (modern Bizerte) was an ancient Phoenician colony that relied heavily on maritime trade."
        ),
        Question(
            id = 30,
            imageRes = R.drawable.img,
            options = listOf("Sfax", "Monastir", "Sousse", "Mahdia"),
            correctAnswerIndex = 2,
            category = Category.PUNIC,
            difficulty = Difficulty.HARD,
            funFact = " Hadrumetum (modern Sousse) was a major Phoenician port that predated the founding of Carthage."
        ),

        // ─── 🏛️ CATEGORY 4: MODERN HERITAGE ────────────────────────────
        Question(
            id = 31,
            imageRes = R.drawable.bourguiba_mausoleum,
            options = listOf("Tunis", "Monastir", "Sousse", "Sfax"),
            correctAnswerIndex = 1,
            category = Category.MODERN,
            difficulty = Difficulty.EASY,
            funFact = "🏛️ Habib Bourguiba, Tunisia's first president, was born and buried in Monastir."
        ),
        Question(
            id = 32,
            imageRes =R.drawable.img,
            options = listOf("Sfax", "Bizerte", "Tunis", "Sousse"),
            correctAnswerIndex = 2,
            category = Category.MODERN,
            difficulty = Difficulty.EASY,
            funFact = "🏙️ Avenue Habib Bourguiba is the central thoroughfare of Tunis, often compared to the Champs-Élysées."
        ),
        Question(
            id = 33,
            imageRes =R.drawable.img,
            options = listOf("Sousse", "Sfax", "Tunis", "Monastir"),
            correctAnswerIndex = 2,
            category = Category.MODERN,
            difficulty = Difficulty.MEDIUM,
            funFact = "🎭 The Municipal Theatre of Tunis is a beautiful example of Art Nouveau architecture, opened in 1902."
        ),
        Question(
            id = 34,
            imageRes = R.drawable.img,
            options = listOf("Monastir", "Tunis", "Sfax", "Gabes"),
            correctAnswerIndex = 1,
            category = Category.MODERN,
            difficulty = Difficulty.EASY,
            funFact = "🕰️ The iconic Clock Tower in Tunis was erected in 2001 and is located at January 14, 2011 Square."
        ),
        Question(
            id = 35,
            imageRes = R.drawable.img,
            options = listOf("Tunis", "Monastir", "Sousse", "Bizerte"),
            correctAnswerIndex = 2,
            category = Category.MODERN,
            difficulty = Difficulty.MEDIUM,
            funFact = "🖼️ The Sousse Archaeological Museum is located inside the Kasbah and houses breathtaking Roman mosaics."
        ),
        Question(
            id = 36,
            imageRes = R.drawable.img,
            options = listOf("Carthage", "Sousse", "Tunis", "Kairouan"),
            correctAnswerIndex = 2,
            category = Category.MODERN,
            difficulty = Difficulty.EASY,
            funFact = "🖼️ The Bardo Museum in Tunis holds one of the most important collections of Roman mosaics in the world."
        ),
        Question(
            id = 37,
            imageRes = R.drawable.img,
            options = listOf("Sfax", "Tunis", "Kairouan", "Mahdia"),
            correctAnswerIndex = 1,
            category = Category.MODERN,
            difficulty = Difficulty.HARD,
            funFact = "🏙️ Modern conservation efforts in Tunis have restored countless historic Dar (palaces) into cultural spaces."
        ),
        Question(
            id = 38,
            imageRes = R.drawable.img,
            options = listOf("Sousse", "Sfax", "Tunis", "Monastir"),
            correctAnswerIndex = 2,
            category = Category.MODERN,
            difficulty = Difficulty.EASY,
            funFact = "🏛️ The City of Culture in Tunis is a massive modern complex featuring theaters, cinemas, and an opera house."
        ),
        Question(
            id = 39,
            imageRes = R.drawable.img,
            options = listOf("Sousse", "Monastir", "Mahdia", "Bizerte"),
            correctAnswerIndex = 1,
            category = Category.MODERN,
            difficulty = Difficulty.EASY,
            funFact = "⛵ The Monastir Marina blends modern tourism infrastructure with traditional coastal architecture."
        ),
        Question(
            id = 40,
            imageRes = R.drawable.img,
            options = listOf("Sfax", "Tunis", "Gabes", "Gafsa"),
            correctAnswerIndex = 0,
            category = Category.MODERN,
            difficulty = Difficulty.MEDIUM,
            funFact = "🏙️ Sfax is Tunisia's second-largest city, functioning as the economic and industrial powerhouse of the south."
        ),

        // ─── 🌿 CATEGORY 5: NATURAL SITES ──────────────────────────────
        Question(
            id = 41,
            imageRes = R.drawable.ichkeul,
            options = listOf("Bizerte", "Jendouba", "Nabeul", "Tozeur"),
            correctAnswerIndex = 0,
            category = Category.NATURAL,
            difficulty = Difficulty.MEDIUM,
            funFact = "🦩 Ichkeul National Park in Bizerte is a vital stopover for hundreds of thousands of migrating birds."
        ),
        Question(
            id = 42,
            imageRes = R.drawable.img,
            options = listOf("Gabes", "Tozeur", "Medenine", "Tataouine"),
            correctAnswerIndex = 1,
            category = Category.NATURAL,
            difficulty = Difficulty.EASY,
            funFact = "🏜️ The Tunisian Sahara features stunning dunes and was a major filming location for Star Wars!"
        ),
        Question(
            id = 43,
            imageRes = R.drawable.img,
            options = listOf("Tataouine", "Gafsa", "Tozeur", "Sfax"),
            correctAnswerIndex = 2,
            category = Category.NATURAL,
            difficulty = Difficulty.MEDIUM,
            funFact = "🧂 Chott El Jerid is the largest salt pan in the Sahara desert, known for its incredible mirages."
        ),
        Question(
            id = 44,
            imageRes =R.drawable.img,
            options = listOf("Gabes", "Tozeur", "Kebili", "Gafsa"),
            correctAnswerIndex = 1,
            category = Category.NATURAL,
            difficulty = Difficulty.HARD,
            funFact = "🌴 Chebika is a breathtaking mountain oasis located at the foot of the Djebel el Negueb mountains."
        ),
        Question(
            id = 45,
            imageRes = R.drawable.img,
            options = listOf("Tozeur", "Gabes", "Tataouine", "Medenine"),
            correctAnswerIndex = 0,
            category = Category.NATURAL,
            difficulty = Difficulty.HARD,
            funFact = "🌊 Tamerza is the largest mountain oasis in Tunisia, famous for its cascading waterfalls."
        ),
        Question(
            id = 46,
            imageRes = R.drawable.img,
            options = listOf("Sfax", "Djerba", "Kerkennah", "Gabes"),
            correctAnswerIndex = 1,
            category = Category.NATURAL,
            difficulty = Difficulty.EASY,
            funFact = "🏝️ Djerba is known as the 'Island of Dreams', featuring beautiful beaches and rich multicultural heritage."
        ),
        Question(
            id = 47,
            imageRes = R.drawable.img,
            options = listOf("Sousse", "Mahdia", "Sfax", "Gabes"),
            correctAnswerIndex = 2,
            category = Category.NATURAL,
            difficulty = Difficulty.MEDIUM,
            funFact = "🏝️ The Kerkennah Islands off the coast of Sfax are famous for their traditional, shallow-water fishing techniques."
        ),
        Question(
            id = 48,
            imageRes = R.drawable.img,
            options = listOf("Zaghouan", "Beja", "Siliana", "Kef"),
            correctAnswerIndex = 0,
            category = Category.NATURAL,
            difficulty = Difficulty.MEDIUM,
            funFact = "⛰️ Mount Zaghouan provided the primary water source for ancient Carthage via a massive 132km aqueduct."
        ),
        Question(
            id = 49,
            imageRes = R.drawable.img,
            options = listOf("Jendouba", "Bizerte", "Beja", "Nabeul"),
            correctAnswerIndex = 0,
            category = Category.NATURAL,
            difficulty = Difficulty.HARD,
            funFact = "🌲 Ain Draham is known for its lush oak forests, red-tiled roofs, and frequent winter snowfall."
        ),
        Question(
            id = 50,
            imageRes =R.drawable.img,
            options = listOf("Nabeul", "Sousse", "Bizerte", "Tunis"),
            correctAnswerIndex = 0,
            category = Category.NATURAL,
            difficulty = Difficulty.EASY,
            funFact = "🍊 Cap Bon is the 'garden of Tunisia', famous for its citrus orchards and beautiful coastline."
        ),

        // ─── 🏙️ CATEGORY 6: CITIES ─────────────────────────────────────
        Question(
            id = 51,
            imageRes = R.drawable.tunis_medina,
            options = listOf("Capital", "Industrial city", "Coastal city", "Desert city"),
            correctAnswerIndex = 0,
            category = Category.CITIES,
            difficulty = Difficulty.EASY,
            funFact = "🏙️ Tunis has been the capital of Tunisia since the 12th century under the Almohad dynasty."
        ),
        Question(
            id = 52,
            imageRes = R.drawable.img,
            options = listOf("Religious city", "Industrial city", "Desert city", "Capital"),
            correctAnswerIndex = 1,
            category = Category.CITIES,
            difficulty = Difficulty.EASY,
            funFact = "🏙️ Sfax is known for its sprawling olive groves and massive fishing and commercial ports."
        ),
        Question(
            id = 53,
            imageRes = R.drawable.img,
            options = listOf("Oasis city", "Northern city", "Coastal city", "Capital"),
            correctAnswerIndex = 2,
            category = Category.CITIES,
            difficulty = Difficulty.EASY,
            funFact = "🏙️ Sousse is known as the 'Pearl of the Sahel', a vibrant mix of beach tourism and deep history."
        ),
        Question(
            id = 54,
            imageRes = R.drawable.kairouan_city,
            options = listOf("Coastal city", "Industrial city", "Religious city", "Northern city"),
            correctAnswerIndex = 2,
            category = Category.CITIES,
            difficulty = Difficulty.EASY,
            funFact = "🏙️ Kairouan is internationally famous for its exquisite hand-woven carpets and traditional Makroudh pastries."
        ),
        Question(
            id = 55,
            imageRes = R.drawable.img,
            options = listOf("Desert city", "Northern city", "Oasis city", "Capital"),
            correctAnswerIndex = 1,
            category = Category.CITIES,
            difficulty = Difficulty.EASY,
            funFact = "🏙️ Bizerte is the northernmost city in Africa, featuring a beautiful old port and a massive moving bridge."
        ),
        Question(
            id = 56,
            imageRes = R.drawable.img,
            options = listOf("Oasis city", "Northern city", "Capital", "Religious city"),
            correctAnswerIndex = 0,
            category = Category.CITIES,
            difficulty = Difficulty.MEDIUM,
            funFact = "🏙️ Gabes is unique for having one of the only coastal oases in the world!"
        ),
        Question(
            id = 57,
            imageRes =R.drawable.img,
            options = listOf("Coastal city", "Industrial city", "Desert city", "Northern city"),
            correctAnswerIndex = 2,
            category = Category.CITIES,
            difficulty = Difficulty.EASY,
            funFact = "🏙️ Tozeur's architecture is instantly recognizable by its intricate, geometric yellow-brick facades."
        ),
        Question(
            id = 58,
            imageRes = R.drawable.img,
            options = listOf("Tourist city", "Oasis city", "Desert city", "Industrial city"),
            correctAnswerIndex = 0,
            category = Category.CITIES,
            difficulty = Difficulty.EASY,
            funFact = "🏙️ Monastir boasts beautiful sandy beaches alongside historic fortresses, making it a major tourist hub."
        ),
        Question(
            id = 59,
            imageRes = R.drawable.img,
            options = listOf("Coastal heritage", "Industrial city", "Northern city", "Desert city"),
            correctAnswerIndex = 0,
            category = Category.CITIES,
            difficulty = Difficulty.MEDIUM,
            funFact = "🏙️ Mahdia was the first capital of the Fatimid Caliphate in 921 AD and has some of the clearest waters in Tunisia."
        ),
        Question(
            id = 60,
            imageRes = R.drawable.img,
            options = listOf("Capital", "Coastal city", "Desert region", "Oasis city"),
            correctAnswerIndex = 2,
            category = Category.CITIES,
            difficulty = Difficulty.MEDIUM,
            funFact = "🏙️ Tataouine is famous for its Ksours (fortified granaries) and gave its name to the planet Tatooine in Star Wars!"
        )
    )

    // ─── Filter helpers ───────────────────────────────────────────────

    fun getByCategory(category: Category): List<Question> =
        allQuestions.filter { it.category == category }

    fun getByDifficulty(difficulty: Difficulty): List<Question> =
        allQuestions.filter { it.difficulty == difficulty }

    fun getByCategoryAndDifficulty(category: Category, difficulty: Difficulty): List<Question> =
        allQuestions.filter { it.category == category && it.difficulty == difficulty }

    fun getCategories(): List<Category> = Category.entries

    fun getDifficulties(): List<Difficulty> = Difficulty.entries
}