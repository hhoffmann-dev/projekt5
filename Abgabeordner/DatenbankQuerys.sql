CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `armour`
--

DROP TABLE IF EXISTS `armour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `armour` (
  `Id` int NOT NULL,
  `Name` varchar(64) NOT NULL,
  `Defence` int NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armour`
--

LOCK TABLES `armour` WRITE;
/*!40000 ALTER TABLE `armour` DISABLE KEYS */;
/*!40000 ALTER TABLE `armour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `character`
--

DROP TABLE IF EXISTS `character`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `CharacterName` varchar(64) NOT NULL,
  `Hitpoints` int NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `character`
--

LOCK TABLES `character` WRITE;
/*!40000 ALTER TABLE `character` DISABLE KEYS */;
INSERT INTO `character` VALUES (1,'Spieler',10),(2,'Alter Mann',5),(3,'Frank',10),(4,'Verkäufer',10),(5,'Bürgermeister',10),(6,'Brigitte',10);
/*!40000 ALTER TABLE `character` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `characterhasarmour`
--

DROP TABLE IF EXISTS `characterhasarmour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `characterhasarmour` (
  `armour_id` int NOT NULL,
  `character_id` int NOT NULL,
  PRIMARY KEY (`armour_id`,`character_id`),
  KEY `fk_CharacterHasArmour_Armour1_idx` (`armour_id`),
  KEY `fk_CharacterHasArmour_Character1_idx` (`character_id`),
  CONSTRAINT `fk_CharacterHasArmour_Armour1` FOREIGN KEY (`armour_id`) REFERENCES `armour` (`Id`),
  CONSTRAINT `fk_CharacterHasArmour_Character1` FOREIGN KEY (`character_id`) REFERENCES `character` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `characterhasarmour`
--

LOCK TABLES `characterhasarmour` WRITE;
/*!40000 ALTER TABLE `characterhasarmour` DISABLE KEYS */;
/*!40000 ALTER TABLE `characterhasarmour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `characterhasdialog`
--

DROP TABLE IF EXISTS `characterhasdialog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `characterhasdialog` (
  `character_id` int NOT NULL,
  `dialog_id` int NOT NULL,
  PRIMARY KEY (`character_id`,`dialog_id`),
  KEY `fk_CharacterHasDialog_Character1_idx` (`character_id`),
  KEY `fk_CharacterHasDialog_Dialog1_idx` (`dialog_id`),
  CONSTRAINT `fk_CharacterHasDialog_Character1` FOREIGN KEY (`character_id`) REFERENCES `character` (`Id`),
  CONSTRAINT `fk_CharacterHasDialog_Dialog1` FOREIGN KEY (`dialog_id`) REFERENCES `dialog` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `characterhasdialog`
--

LOCK TABLES `characterhasdialog` WRITE;
/*!40000 ALTER TABLE `characterhasdialog` DISABLE KEYS */;
INSERT INTO `characterhasdialog` VALUES (2,2),(2,3),(2,4),(3,11),(3,12),(4,15),(5,17);
/*!40000 ALTER TABLE `characterhasdialog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `characterhasweapon`
--

DROP TABLE IF EXISTS `characterhasweapon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `characterhasweapon` (
  `character_id` int NOT NULL,
  `weapon_id` int NOT NULL,
  PRIMARY KEY (`character_id`,`weapon_id`),
  KEY `fk_CharacterHasWeapon_Character1_idx` (`character_id`),
  KEY `fk_CharacterHasWeapon_Weapon1_idx` (`weapon_id`),
  CONSTRAINT `fk_CharacterHasWeapon_Character1` FOREIGN KEY (`character_id`) REFERENCES `character` (`Id`),
  CONSTRAINT `fk_CharacterHasWeapon_Weapon1` FOREIGN KEY (`weapon_id`) REFERENCES `weapon` (`idWeapon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `characterhasweapon`
--

LOCK TABLES `characterhasweapon` WRITE;
/*!40000 ALTER TABLE `characterhasweapon` DISABLE KEYS */;
/*!40000 ALTER TABLE `characterhasweapon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dialog`
--

DROP TABLE IF EXISTS `dialog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dialog` (
  `Id` int NOT NULL,
  `Text` varchar(4096) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dialog`
--

LOCK TABLES `dialog` WRITE;
/*!40000 ALTER TABLE `dialog` DISABLE KEYS */;
INSERT INTO `dialog` VALUES (1,'Auf halben Wege siehst du etwas oder jemanden auf dem Boden liegen. Es ist ein schwerverletzter alter Mann. Du hörst ein leises Murmeln aus der Richtung des Mannes und versuchst ihm zu helfen, doch es ist zu spät. Er wird seinen Verletzungen erliegen. Sein leises Murmeln wird deutlicher: “Sie haben den Kris...tall. Sie dürfen ihn nicht … einsetzen”.'),(2,'“die…Bruderschaft...der...Dunkelh...”'),(3,'Alter Mann: “Sirius...Kristall” '),(4,'Alter Mann: “Geh nach...Westen. Stelle das Gleichgewicht wieder her!” Der alte Mann verstirbt. Du gehst weiter. Nach einiger Zeit spaltet sich der Weg in zwei Richtungen. Nach Westen oder nach Norden. '),(5,'Du gehst weiter nach Norden, doch plötzlich tauchen aus dem nichts 5 Banditen vor dir auf und versperren den Weg.Der scheinbare Anführer sagt: “Na wen haben wir denn da. Wo darf es denn hingehen?   Anführer: “Du bist wohl nicht sehr gesprächig. Wie auch immer. Du wandelst durch mein Territorium und das kostet dich was: 50.000 Gold-Dublonen oder dein minderwertiges Leben. '),(6,'Nach dem kräftezehrenden Kampf musst du dich zurückziehen. Du nimmst die Karte und die Golddublonen und schlägst in Richtung Westen ein, um zum Dorf Fenshui zu gelangen.'),(7,'Du nimmst deine Beine ihn die Hand und rennst den Weg zurück. Du nimmst die Abbiegung in Richtung Westen. Die Banditen kleben dir im Nacken. Du rennst und rennst. Nach einiger Zeit geht dir die Puste aus und du schaust nach hinten. Die Banditen haben von dir abgelassen. Du nimmst den Weg weiter Richtung Westen.'),(8,'Du gehst entspannt den Weg nach Westen.'),(9,'Der Wald lichtet sich und du siehst Ackerflächen, Tierweiden und in der ferne ein kleines Dorf. Es wird dunkel. Die Sonne geht langsam unter. Du findest am Rande des Dorfes eine Hütte und näherst dich diese. Plötzlich tritt ein älterer Mann mit einem Schwert heraus und fragt: “Was machst du auf meinem Land, Fremder!? Wolltest du meine wertvolle Sarim-Wolle klauen, du dreckiger Bandit!'),(10,'Alter Mann: “Verschwinde trotzdem!! Geh woanders hin!” Aus der Hütte tritt eine ältere Frau hervor. Alte Frau: “Was ist das hier für ein Lärm! Frank steck das verdammte Schwert weg! Und wer sind Sie und was wollen sie hier?” Frank: “Das ist ein Bandit! Samantha... geh wieder ins Haus!” Spieler: “Ich brauche nur eine Bleibe für heute Nacht.” Samantha: “Lass gut sein Frank. Steck das Schwert wieder ein. Wäre er / sie ein Bandit, hätte er / sie dir schon längst eins übergebraten, mich erdrosselt und wäre mit der Wolle über alle Berge. Das ist für heute Abend unser Gast. Kommt rein, das Essen ist fertig.” Frank: “Alles klar, Liebling” Beim Essen kommt ihr ins Gespräch und plaudert über vergangene Abenteuer. Frank: “Du als Kopfgeldjäger hast ja viel Kampferfahrung oder? Dann kannst du ja die Bestie umbringen, die unsere Nutztiere reißt und so einen enormen Schaden verursacht. Laut Augenzeugen sind das monströse Spinnen. Ihre Königin, die größte von allen, wir nennen sie Arachnida, befindet sich in einer Höhle im Süden.Viele haben es versucht sie zu töten, sind aber gescheitert und nicht zurückgekehrt.Es soll eine gute Belohnung ausgesetzt sein, wer die Fänge der Bestie ins Rathaus des Dorfes bringt.Vielleicht wär das ja für dich was!” '),(11,'Frank: “Das wirst du schon packen. Wir vertrauen auf deinen Fähigkeiten”'),(12,'Frank: “Oh, das ist Schade. Alle im Dorf sind verzweifelt.”'),(13,'Nach dem Essen legst du dich aufs Ohr und ruhst dich aus. Ein neuer Tag bricht an. Was machst du jetzt?'),(14,'Du gehst zum Shop. Verkäufer: “Herzlich Willkommen. Verkäufer: “Herzlich Willkommen. Ich habe dich hier noch nie gesehen, geschweige denn hier gekauft, Fremder? Ich gewähre dir Erstkundenrabatt.”'),(15,'Verkäufer: “Beehren Sie uns bald wieder”'),(16,'Du gehst zum Rathaus. Am Rathaus angekommen, findest du ein Schild: “Auftrag, wer die Fänge der Spinnenbestie ins Rathaus bringt, dem erwartet eine große Belohnung. 20.000 Golddublonen.”'),(17,'Der Bürgermeister tritt hervor. Bürgermeister: “Sei gegrüßt, Fremder. Wie ich sehe interessieren Sie sich für den Auftrag. Seien Sie bloß auf der Hut. Diese Biester sind gerissen und greifen selten alleine an. Selbst unsere tapfersten Kämpfer kamen nicht mehr zurück. Nimm also genügend Heiltränke mit. Die Höhle dieser Brut ist laut Hörensagen in Richtung Süden. Viel Glück, Fremder. Möge Gott deiner Seele gnädig sein.”  '),(18,'Du begibst dich nach Süden. Nach einem langen Fußmarsch siehst du einen großen Hügel. Dieser ist zum Teil mit Spinnennetzen übersät und in diesen Netzen befinden sich ab und zu Kokons. Wahrscheinlich befinden sich darin ihre Opfer eingewickelt. Manche Kokons sind aufgebrochen. Es hängen Sarim-Schaf-, Laturi- und andere Nutztierleichen heraus. Am Rande des Hügels befindet sich eine kleine unscheinbare Höhle. Du versteckst dich in der Nähe des Höhleneingangs in ein Gestrüpp und beobachtest die Situation. Plötzlich wirst du Zeuge wie eine Spinne ein neues Opfer anschleppt. Du hörst ein stumpfes Schreien und dann ein Hilferuf aus dem Kokon, dass von der Spinne hinter sich her schleift. Unbekannt: “Hiiiiillfeee!!!!” Es muss sich um eine Frau handeln. Was machst du?  '),(19,'Du springst aus dem Gestrüpp und rennst zielstrebig zur Spinne. Mit einem gezielten Angriff schreckst du das Tier zurück und schneidest die Person aus dem Kokon. Mit einigen gut gezielten Schlägen kannst du die Spinne letztendlich niederstrecken.'),(20,'Unbekannte: “Vielen Dank, Fremder. Ich wurde auf den Heimweg nach Kresta von diesem Mistvieh überfallen und ich dachte ich würde sterben. Achja mein Name ist übrigens Brigitte. Ich stehe in deiner Schuld.Nimm dies als Zeichen meiner Dankbarkeit”. Spieler bekommt 1000 Golddublonen. Brigitte:\"“Vielleicht sieht man sich ja mal wieder”“Vielleicht sieht man sich ja mal wieder”Vielleicht sieht man sich ja mal wieder!\" Brigitte läuft in Richtung Norden davon.'),(21,'Du wartest ab. Die Spinne schleppt das Opfer in die Höhle und sie verschwinden in der Dunkelheit. Es ist ruhig. Du hörst wie der Wind durch die Bäume weht und die Blätter zum Rauschen bringt. das Gezwitscher von Vögeln. Ansonsten rührt sich nichts.'),(22,'Du entschließt dich die Höhle mit großer Vorsicht zu betreten. Du durchschreitest den Eingang. Es ist stockdunkel. Du schlägst dich irgendwie durch ohne zu stürzen. Deine Anwesenheit ist nicht mehr unbemerkt. Du wurdest beobachtet. Du siehst ein bläuliches Licht am Ende des Höhlenganges und bewegst dich darauf zu. Du wirst durch das Licht kurzzeitig geblendet. Als es wieder einigermaßen ging, siehst du einen großen Hohlraum gefüllt mit vielen blau leuchtenden, von gigantisch über sehr groß bishin zu faustgroßen Kristallen. Es ist als wär man in einer anderen Welt gelangt. In diesem Teil der Höhle ist fast alles mit Spinnenweben, Kokons, aufgerissene Kokons und ausgesaugten Leichen übersäht. Sei es von Nutztieren oder anderem Getier, sogar von Menschen. Der Anblick ist schockierend und verstörend zugleich. Es ist viel schlimmer als am Eingang. Du versuchst dich von diesem Schock zu erholen und schreitest weiter voran. Plötzlich aus dem Nichts fallen 3 große Spinnen dir in den Rücken. Du konntest diesen Angriff ausweichen. Die erste Spinne kann der Spieler noch ohne Problem bezwingen. Allerdings haben die verbliebenden Spinnen daraus gelernt... Plötzlich koordinierten sie ihre Angriffe und dem Helden viel es schwer gegen sie anzukommen. Doch plötzlich verhakten sich die Beine der beiden Spinnen gegenseitig. Der Held sah seine Chance und Schlug die beiden mit einem Rundumschlag in zwei Hälften!    '),(23,'Der Kampf ist vorbei. Durch diese Aktion, sind jetzt die Spinnen in Alarmbereitschaft. Ab hier nützt nur noch dein Stealth-Training. Du schleichst dich an den Spinnenpatrouillen vorbei und findest einen weiteren kleineren Hohlraum. In diesem befinden sich viele verschlossene Kokons und Spinneneier. Es handelt sich wohl um eine von vielen Brutstätten, die in der Höhle verteilt sind. Du hörst Schritte und versteckst dich zwischen den schleimigen Eiern. Es betritt eine Spinne die Brutstätte und schleift einen Kokon hinter sich her. Man hört ein stumpfes “Määäh” aus dem Kokon. Die Spinne klebt den Kokon an die Wand und verschwindet wieder.  Du kriechst aus dem Versteck und gehst weiter. Du findest im nächsten Höhlenkorridor einen weiteren Hohlraum. In diesem sind auch wieder viele unberührte sowie zerstörte Kokons und es liegen viele Leichen auf dem Boden.  Du entdeckst ein großes Spinnennetz an der Wand. Dieses kann nicht von den normalen Spinnen erbaut worden sein bzw. Es ist unwahrscheinlich. Hinter dir taucht ein großer Schatten in Spinnenform auf. Du drehst dich um und siehst eine monströse Spinne mit Fängen so groß wie dein Arm. Sie begibt sich in Angriffsposition und es entbrennt ein epischer Kampf zwischen dir und der Königin der Achtbeiner. Das war der schwierigste Kampf, den Der Held je zuvor beschreiten musste. Die Königen war schnell. Sie war agil und sie war bärenstark! Also wich der Held eine Zeit lang erstmal aus und wartete auf seine Chance. Als die Königin müder wurde, nahm der Held großen Schwung und schleuderte sein Schwert direkt in den Kopf der Königin. Es kamen noch ein paar ataktische Bewegungen und Todesschreie, bis sie vollkommen verstummte.  '),(24,'Der Kampf ist vorüber. Die Königin ist tot und du schneidest ihre Fänge aus ihrem Kadaver. Du machst dich schnell auf dem Weg aus der Höhle. Auf einmal siehst du in den Augenwinkeln etwas Glitzerndes. Um den Hals einer Leiche hängt ein kleines goldenes Amulett mit einem Zeichen. Neben der Leiche liegt eine ziemlich mitgenommene Schriftrolle. In dieser Schriftrolle steht: “Bringt … Siriuskristall...Versteck...Kresta...”. Der Rest ist unleserlich. Auf der Schriftrolle ist das gleiche Zeichen wie auf dem Amulett. Der Spieler nimmt das Amulett und die Schriftrolle mit. Plötzlich gibt es ein Erdbeben und die Höhle droht komplett in sich zusammenzufallen. Von der Decke fallen Gesteinsbrocken. Du nimmst die Beine in die Hand und läufst los.  Du weichst jedem Geröll aus das von der Decke stürzt. Du springst aus der Höhle während sie hinter dir einstürzt und alle Spinnen und ihre Brut unter sich begräbt. '),(25,'\"Ich werde doch jetzt nicht umkehren!\"'),(26,'Du bist beim Kampf gestorben.'),(27,'Sie sind weiter nach Norden gezogen und sind am Ende ihrer Reise angekommen. Treffen sie nächstes Mal die richtigen Entscheidungen, wenn sie eine spannende Entwicklung entwickeln wollen :)'),(28,'Herzlichen Glückwunsch! Sie sind ein wahrer Held! Leider haben Sie ihre Entscheidungen aber nicht ganz richtig gewählt! Den Endboss haben Sie leider nicht getroffen! Vielleicht nächstes Mal :)'),(29,'Herzlichen Glückwunsch! Sie haben alle Entscheidungen richtig getroffen und haben das richtige Ende der Episode 1 von Laverra erreicht! Gut gemacht!');
/*!40000 ALTER TABLE `dialog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dialoghasoption`
--

DROP TABLE IF EXISTS `dialoghasoption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dialoghasoption` (
  `dialog_id` int NOT NULL,
  `dialogoption_id` int NOT NULL,
  PRIMARY KEY (`dialog_id`,`dialogoption_id`),
  KEY `fk_DialogHasDialogOption_DialogOption1_idx` (`dialogoption_id`),
  KEY `fk_DialogHasDialogOption_Dialog1_idx` (`dialog_id`),
  CONSTRAINT `fk_DialogHasDialogOption_Dialog1` FOREIGN KEY (`dialog_id`) REFERENCES `dialog` (`Id`),
  CONSTRAINT `fk_DialogHasDialogOption_DialogOption1` FOREIGN KEY (`dialogoption_id`) REFERENCES `dialogoption` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dialoghasoption`
--

LOCK TABLES `dialoghasoption` WRITE;
/*!40000 ALTER TABLE `dialoghasoption` DISABLE KEYS */;
INSERT INTO `dialoghasoption` VALUES (4,1),(4,2),(5,4),(5,5),(1,6),(1,7),(9,8),(9,9),(9,10),(10,11),(10,12),(13,13),(13,14),(13,15),(16,16),(16,17),(18,18),(18,19),(4,20),(14,21),(17,22);
/*!40000 ALTER TABLE `dialoghasoption` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dialogoption`
--

DROP TABLE IF EXISTS `dialogoption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dialogoption` (
  `Id` int NOT NULL,
  `DialogOptionText` varchar(512) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dialogoption`
--

LOCK TABLES `dialogoption` WRITE;
/*!40000 ALTER TABLE `dialogoption` DISABLE KEYS */;
INSERT INTO `dialogoption` VALUES (1,'Geh nach Westen '),(2,'Geh nach Norden '),(3,'Geh zurück '),(4,'Kämpfen'),(5,'Fliehen'),(6,'\"Was heißt Sie. Wer war das?”'),(7,'\"Welchen Kristall?”'),(8,'\"Ich benötige nur eine Bleibe über Nacht.\"'),(9,'\"Ich bin kein dreckiger Bandit!\"'),(10,'\"Bleib zurück alter Mann. Sonst rollt dein Kopf schneller den Abhang hinunter als du bis drei zählen kannst!\"'),(11,'Na klar, stelle ich mich der Herausforderung.'),(12,'Ähm, nee eigentlich bin ich nur auf der Durchreise.'),(13,'Zum Shop gehen'),(14,'Zum Rathaus gehen'),(15,'Weiter nach Norden ziehen'),(16,'Auftrag Annehmen'),(17,'Auftrag Ablehnen'),(18,'Helfen'),(19,'Ignorieren'),(20,'Geh zurück'),(21,'Eine Lebensmittelration für ein paar Tage einkaufen.'),(22,'Geh nach Süden');
/*!40000 ALTER TABLE `dialogoption` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `environment`
--

DROP TABLE IF EXISTS `environment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `environment` (
  `Id` int NOT NULL,
  `EnvironmentName` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `environment`
--

LOCK TABLES `environment` WRITE;
/*!40000 ALTER TABLE `environment` DISABLE KEYS */;
INSERT INTO `environment` VALUES (1,'Arestinen-Wald'),(2,'Hinterhalt Arestinen-Wald'),(3,'Hinterhalt Flucht'),(4,'Hinterhalt Sieg'),(5,'Weg nach Westen'),(6,'Dorf'),(7,'Nach dem Essen'),(8,'Laden'),(9,'Rathaus'),(10,'Weg nach Norden'),(11,'Spinnenhöhle Frau retten'),(12,'Spinnenhöhle Frau nicht retten'),(13,'Spinnenhöhle'),(14,'Spinnenhöhle nach dem Kampf'),(15,'Nach dem Bosskampf gegen die Spinne'),(16,'Weg nach Süden');
/*!40000 ALTER TABLE `environment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `environmenthasdialog`
--

DROP TABLE IF EXISTS `environmenthasdialog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `environmenthasdialog` (
  `environment_id` int NOT NULL,
  `dialog_id` int NOT NULL,
  PRIMARY KEY (`environment_id`,`dialog_id`),
  KEY `fk_EnvironmentHasDialog_Dialog1_idx` (`dialog_id`),
  CONSTRAINT `fk_EnvironmentHasDialog_Dialog1` FOREIGN KEY (`dialog_id`) REFERENCES `dialog` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `environmenthasdialog`
--

LOCK TABLES `environmenthasdialog` WRITE;
/*!40000 ALTER TABLE `environmenthasdialog` DISABLE KEYS */;
INSERT INTO `environmenthasdialog` VALUES (1,1),(2,5),(3,6),(4,7),(5,8),(6,9),(7,13),(8,14),(9,16),(16,18),(11,19),(12,21),(13,22),(14,23),(15,24),(10,27);
/*!40000 ALTER TABLE `environmenthasdialog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `savegame`
--

DROP TABLE IF EXISTS `savegame`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `savegame` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `dialog_id` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `www_idx` (`user_id`),
  KEY `fk_savegame_DialogId_idx` (`dialog_id`),
  CONSTRAINT `fk_savegame_DialogId` FOREIGN KEY (`dialog_id`) REFERENCES `dialog` (`Id`),
  CONSTRAINT `fk_savegame_UserId` FOREIGN KEY (`user_id`) REFERENCES `userdata` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `savegame`
--

LOCK TABLES `savegame` WRITE;
/*!40000 ALTER TABLE `savegame` DISABLE KEYS */;
INSERT INTO `savegame` VALUES (1,1,4),(2,2,1),(3,3,7),(4,4,8);
/*!40000 ALTER TABLE `savegame` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdata`
--

DROP TABLE IF EXISTS `userdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdata` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Password` varchar(60) NOT NULL,
  `UserName` varchar(60) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdata`
--

LOCK TABLES `userdata` WRITE;
/*!40000 ALTER TABLE `userdata` DISABLE KEYS */;
INSERT INTO `userdata` VALUES (1,'ps123','Alwin'),(2,'345','Peter'),(3,'ggg','Ted'),(4,'fff','Alfons');
/*!40000 ALTER TABLE `userdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weapon`
--

DROP TABLE IF EXISTS `weapon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weapon` (
  `idWeapon` int NOT NULL,
  `WeaponName` varchar(64) NOT NULL,
  `Damage` int NOT NULL,
  PRIMARY KEY (`idWeapon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weapon`
--

LOCK TABLES `weapon` WRITE;
/*!40000 ALTER TABLE `weapon` DISABLE KEYS */;
/*!40000 ALTER TABLE `weapon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-11 19:05:04
