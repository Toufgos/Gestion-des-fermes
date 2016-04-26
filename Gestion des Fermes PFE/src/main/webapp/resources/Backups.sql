
--
-- Contenu de la table `modeirreguation`
--

INSERT INTO `modeirreguation` (`id_mode`, `description`, `nom_mode`) VALUES
(1, 'petites superficie de polyculture', 'Goutte-a-Goutte'),
(2, 'aspersion à faible débit', 'aspersion'),
(3, 'L''irrigation de surface, également nommée irrigation par sillons, « à la raie » ou irrigation gravitaire', 'Écoulement de surface'),
(4, 'Le principe est le même que pour l''irrigation par aspersion, mais de façon plus localisée. La micro-aspersion est plus économe en consommation d''eau.', 'micro-aspersion'),
(5, 'voici un nouveau mode d''irrigation \n', 'new mode'),
(8, 'voici un new mode', 'new mode'),
(9, 'voici un new mode', 'new mode');
-- --------------------------------------------------------

--
-- Contenu de la table `groupe`
--

INSERT INTO `groupe` (`id`, `Description`, `libelle`) VALUES
(1, 'groupe1', 'GRP1'),
(7, 'groupe2', 'GRP2'),
(8, 'groupe3', 'GRP3');


-- --------------------------------------------------------


--
-- Contenu de la table `personnel`
--

INSERT INTO `personnel` (`id`, `cin_Personnel`, `description`, `nom_Personnel`, `poste_Personnel`) VALUES
(1, 'BB101182', 'departement informatique', 'ilyas', 'Chef');


--
-- Contenu de la table `ferme`
--

INSERT INTO `ferme` (`id_Ferme`, `Adresse_Ferme`, `Nom_Ferme`, `observation_Ferme`, `pays_Ferme`, `Prop_de_Ferme`, `titre_foncier_ferme`, `ville_Ferme`, `gerant_frm`, `Groupe_ID`) VALUES
(1, 'Daour Thami RT133:', 'FermeSaada', 'une ferme tres vaste qui contient ...', 'Maroc', 'Mohamed', 3329.98, 'Casa', 1, 8),
(7, 'Daour Thami RT133_1', 'FermeSaada_1', 'obs', 'maroc', 'Mohamed', 3329.98, 'Casa', 1, 7),
(8, '@ casa', 'Test', NULL, NULL, 'owner', 908.92, 'Casa', NULL, 1),
(9, '@ casa 2', 'Test2', NULL, NULL, 'owner', 908.92, 'Casa', NULL, 1),
(10, '@ casa 3', 'Test3', NULL, NULL, 'owner', 908.92, 'Casa', NULL, 1),
(11, '@ DomaineA', 'DomaineA', NULL, NULL, NULL, 192.1, '@ DomaineA', NULL, 8),
(12, 'Adresse Test', 'FermeTest', NULL, NULL, NULL, 827.12, 'Adresse Test', NULL, 7),
(13, 'nEw aDresse', 'newFERME', NULL, NULL, NULL, 819.2, 'nEw aDresse', NULL, 7),
(14, 'okokokok', 'ok', NULL, NULL, NULL, 1000, 'okokokok', NULL, 1);

-- --------------------------------------------------------


--
-- Contenu de la table `personnel_fermes`
--

INSERT INTO `personnel_fermes` (`Ferme_id_Ferme`, `personnels_id`) VALUES
(1, 1);



INSERT INTO `parcellaire` (`type_parcellaire`, `id_parce`, `libel`, `surface_brute`, `surface_inculte`, `surface_Net`, `description`, `Ferme_ID`, `Mode`, `occupation_id`) VALUES
('Bour', 1, 'ChampsM', 3325, 3300, 3300, 'Parcellaire Bour', 1, NULL, NULL),
('Irregue', 3, 'ChampsA', 3325, 3300, 3300, 'parceUrregue', 7, 2, NULL),
('Irregue', 5, 'ChampsE', 3325, 3300, 3300, 'parceUrregue', NULL, 3, NULL),
('Irregue', 7, 'ChampsK', 3325, 3300, 3300, 'parceUrregue', NULL, 4, NULL),
('Bour', 9, 'ChampsO', 3325, 3300, 3300, 'Parcellaire Bour', 1, NULL, NULL),
('Bour', 10, 'TestParceByForm', 2000, 89, 1911, 'Cette Parcellaire est bour', 1, NULL, NULL),
('Irregue', 11, 'TestParceByForm2', 73872, 92, 73780, 'cette parcellaire est irregue', 1, 3, NULL),
('Irregue', 12, 'TestParceX', 83973, 300, 83673, 'cette parcellaire est irregue', 1, 1, NULL),
('Irregue', 13, 'testA', 819, 18, 801, NULL, 7, 2, NULL),
('Bour', 14, 'Parcelam', 1092029, 1920129, -828100, 'Cette Parcellaire est bour', 10, NULL, NULL),
('Bour', 16, 'NouvelleParceele', 1900, 29, 0, '102', 12, NULL, NULL);

-- --------------------------------------------------------



--
-- Contenu de la table `activite`
--

INSERT INTO `activite` (`id`, `libelle`, `observation`) VALUES
(1, 'Arboriculture', 'observation pour Arboriculture'),
(2, 'Elevage', 'observation test Elvage'),
(3, 'test', 'new test');

-- --------------------------------------------------------


--
-- Contenu de la table `famille`
--

INSERT INTO `famille` (`id`, `Description`, `libelle`, `activite_id`) VALUES
(1, NULL, 'Plantation', 1),
(2, 'pour tous qui est culture', 'Culturee', 1),
(3, 'I am testing ', 'FamilleTest', 1),
(4, 'chuf db', 'bismiallzh', 2),
(5, 'famille de test', 'test ', NULL),
(6, 'test', 'test', 3),
(7, 'ila sda9 hada rah salina', 'nouveau test', 2),
(9, 'yes it is over', 'new Test', 3),
(10, 'éo&eirhoi&apj', 'new Famiille', 3),
(11, 'voici une nouvelle famille', 'nouvelleFamille', 1),
(13, 'i am just testing', 'testingggggg', 3);

-- --------------------------------------------------------



--
-- Contenu de la table `sousfamille`
--

INSERT INTO `sousfamille` (`id`, `Libelle`, `famille_id`) VALUES
(1, 'Agrumes', 1),
(2, 'Pommier', 1),
(3, 'Nectarinier', 1),
(4, 'Pecher', 1),
(5, 'Tomate', 2),
(6, 'Cereale', 2);

-- --------------------------------------------------------

--
-- Contenu de la table `variete`
--

INSERT INTO `variete` (`id`, `AgeAdulte`, `nom`, `sousfamille_id`) VALUES
(1, 7, 'Navel', 1),
(2, 4, 'Clementine', 1),
(3, 5, 'Golden', 2),
(4, 3, 'Holdem', 3),
(5, 0, 'Ble dur', 6),
(6, 32, 'var 6', 3),
(7, 30, 'var 7', 4),
(8, 32, 'var 8', 4),
(9, 100, 'Vari100', 5),
(10, 1020, 'Varihhh100', 6),
(11, 23, 'Maticha', 5),
(12, 10, 'peche', 4);

-- --------------------------------------------------------







--
-- Contenu de la table `occupation`
--

INSERT INTO `occupation` (`type_Occupation`, `id`, `ordrevariete`, `NbrArbres`, `annePlantation`, `ecartX`, `ecartY`, `remarque`,    `var`) VALUES
('Mere', 1, 1, NULL, NULL, NULL, NULL, NULL,   9),
('Plantation', 2, 1, 1000, 2000, 1.2, 1.4, 'remarque concerne cette partie',  10),
('Plantation', 3, 1, 1000, 2015, 0.9, 1.2, NULL, 1);

-- --------------------------------------------------------


--
-- Contenu de la table `coordonnesgps`
--

INSERT INTO `coordonnesgps` (`id`, `latitude`, `longitude`, `ferme_id_Ferme`, `parcellaire_id_parce`) VALUES
(15, 32.34413695244378, 50.782928466796875, 9, NULL),
(16, 32.47630583911405, 50.789794921875, 9, NULL),
(17, 32.52495081620842, 51.123504638671875, 9, NULL),
(18, 32.49831515928785, 51.285552978515625, 9, NULL),
(19, 32.47283019121424, 51.321258544921875, 9, NULL),
(20, 32.44154332278176, 51.280059814453125, 9, NULL),
(21, 32.450814638795634, 51.35009765625, 9, NULL),
(22, 32.4056079665009, 51.339111328125, 9, NULL),
(23, 32.410245591059066, 51.25946044921875, 9, NULL),
(24, 32.35805857934527, 51.351470947265625, 9, NULL),
(25, 32.29191177481541, 51.3336181640625, 9, NULL),
(26, 32.276818896044986, 51.269073486328125, 9, NULL),
(27, 32.262884778751925, 51.326751708984375, 9, NULL),
(28, 32.232686852202875, 51.2127685546875, 9, NULL),
(29, 32.29075087332242, 51.1468505859375, 9, NULL),
(30, 32.24197959136709, 51.115264892578125, 9, NULL),
(31, 32.371296636739935, 50.96626281738281, 10, NULL),
(32, 32.38782336469664, 50.97450256347656, 10, NULL),
(33, 32.386953612275335, 51.01329803466797, 10, NULL),
(34, 32.37796568022705, 51.03973388671875, 10, NULL),
(35, 32.37013675285345, 51.030120849609375, 10, NULL),
(36, 32.359987133974755, 51.02497100830078, 10, NULL),
(37, 32.36114714808815, 51.00574493408203, 10, NULL),
(38, 32.35621698533103, 51.00231170654297, 10, NULL),
(39, 32.23917250846437, 51.215171813964844, NULL, 1),
(40, 32.33495137138351, 51.36554718017578, NULL, 1),
(41, 32.35815524834309, 51.34254455566406, NULL, 1),
(42, 32.260658990928334, 51.185646057128906, NULL, 1),
(45, 32.33137357906431, 50.780181884765625, 1, NULL),
(46, 32.51221300840418, 50.9161376953125, 1, NULL),
(47, 32.51105493635798, 51.295166015625, 1, NULL),
(48, 32.33833564223361, 51.455841064453125, 1, NULL),
(49, 32.190857766647476, 51.244354248046875, 1, NULL),
(50, 32.178072820427815, 50.815887451171875, 1, NULL),
(51, 32.19783061686426, 50.403900146484375, 1, NULL),
(52, 32.326731906121125, 50.390167236328125, 1, NULL),
(53, 32.32557145070082, 50.7073974609375, 1, NULL),
(54, 32.49484036139217, 50.69915771484375, 1, NULL),
(55, 32.47862286316388, 50.77056884765625, 1, NULL),
(62, 32.182586496538306, 51.00677490234375, 11, NULL),
(63, 32.22906629627297, 51.00677490234375, 11, NULL),
(64, 32.238359405722655, 51.031494140625, 11, NULL),
(65, 32.22906629627297, 51.064453125, 11, NULL),
(66, 32.20815332547327, 51.097412109375, 11, NULL),
(67, 32.20118126633929, 51.12213134765625, 11, NULL),
(68, 32.18026188320706, 51.1358642578125, 11, NULL),
(69, 32.1360829562021, 51.16607666015625, 11, NULL),
(70, 32.115148622612445, 51.1688232421875, 11, NULL),
(71, 32.091882620021785, 51.185302734375, 11, NULL),
(72, 32.05231681645637, 51.1962890625, 11, NULL),
(73, 32.03602003973757, 51.17156982421875, 11, NULL),
(74, 32.05697250541851, 51.1248779296875, 11, NULL),
(75, 32.084901663548315, 51.0809326171875, 11, NULL),
(76, 32.12445336381827, 51.03973388671875, 11, NULL),
(77, 32.15701248607007, 51.02325439453125, 11, NULL),
(84, 32.39387757528645, 50.9765625, 7, NULL),
(85, 32.381411159273405, 51.119728088378906, 7, NULL),
(86, 32.303674735685554, 51.002655029296875, 7, NULL),
(87, 32.38344069307763, 50.96076965332031, 12, NULL),
(88, 32.3964866073953, 51.0589599609375, 12, NULL),
(89, 32.3271767410611, 51.076812744140625, 12, NULL),
(90, 32.38315076246838, 51.01844787597656, 14, NULL),
(91, 32.381701095465345, 51.10221862792969, 14, NULL),
(92, 32.319633552035235, 51.10496520996094, 14, NULL),
(93, 32.317022301743656, 51.01604461669922, 14, NULL),
(117, 32.39387757528645, 50.976905822753906, NULL, 13),
(118, 32.36024330444844, 50.98686218261719, NULL, 13),
(119, 32.364593268313314, 51.03080749511719, NULL, 13),
(120, 32.37242267585022, 51.029090881347656, NULL, 13),
(121, 32.37358253040168, 51.0589599609375, NULL, 13),
(122, 32.37561224004946, 51.057586669921875, NULL, 13),
(123, 32.37967152258281, 51.07372283935547, NULL, 13),
(124, 32.36749312795217, 51.0809326171875, NULL, 13),
(125, 32.36923299908516, 51.09020233154297, NULL, 13),
(126, 32.36372329228304, 51.09294891357422, NULL, 13),
(127, 32.381411159273405, 51.119384765625, NULL, 13),
(128, 32.303674735685554, 51.00231170654297, NULL, 3),
(129, 32.36198331510819, 51.09020233154297, NULL, 3),
(130, 32.37358253040168, 51.059303283691406, NULL, 3),
(131, 32.372712640883556, 51.029090881347656, NULL, 3),
(132, 32.365173247682634, 51.03046417236328, NULL, 3),
(133, 32.36024330444844, 50.98651885986328, NULL, 3),
(134, 32.38025140520136, 51.02428436279297, NULL, 5),
(135, 32.37909163624265, 51.09466552734375, NULL, 5),
(136, 32.36575322333122, 51.09638214111328, NULL, 5),
(137, 32.3672031461742, 51.0260009765625, NULL, 5);

-- --------------------------------------------------------


--
