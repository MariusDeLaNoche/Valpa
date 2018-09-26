
/*==============================================================*/
/* Table: TYPESUPPLEMENT                                        */
/*==============================================================*/
insert into typesupplement(libellesupplement) 
values('Limite de l''espace de stockage');
insert into typesupplement(libellesupplement) 
values('Nombre maximum d''opérations');
insert into typesupplement(libellesupplement) 
values('Limite de bande passante streaming');

/*==============================================================*/
/* Table: SUPPLEMENT                                            */
/*==============================================================*/
insert into supplement(tranchesupplement, tarifsupplement, IDTYPESUPPLEMENT)
values(1000, 1.0, 1);
insert into supplement(tranchesupplement, tarifsupplement, IDTYPESUPPLEMENT)
values(20, 0.50, 2);
insert into supplement(tranchesupplement, tarifsupplement, IDTYPESUPPLEMENT)
values(1000, 0.10, 3);
insert into supplement(tranchesupplement, tarifsupplement, IDTYPESUPPLEMENT)
values(500, 0.06, 3);

/*==============================================================*/
/* Table: FORFAIT                                               */
/*==============================================================*/
insert into forfait(libelleforfait)
values('Forfait Standard');

/*==============================================================*/
/* Table: TARIFICATION                                          */
/*==============================================================*/
insert into tarification
(	idforfait,
	tariftarification, 
	stockagetarification,
	nboperationstarification, 
	fluxtarification, 
	activetarification )
values(1,10,100000000000,300,1000000000000,true);

/*==============================================================*/
/* Table: TARIFICATIONSUPPLEMENT                                */
/*==============================================================*/
insert into tarificationsupplement (idsupplement, idtarification)
values(1,1);
insert into tarificationsupplement (idsupplement, idtarification)
values(2,1);
insert into tarificationsupplement (idsupplement, idtarification)
values(3,1);



/* --------------------------------------------------------------------------------------- */



/*==============================================================*/
/* Table: UTILISATEUR                                */
/*==============================================================*/
insert into utilisateur (loginUtilisateur, nomutilisateur, prenomutilisateur, mdpUtilisateur, IDFORFAIT) values('Enrique','Fernand','Enrique', '3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2', 1);

/*==============================================================*/
/* Table: TYPEFICHIER                                */
/*==============================================================*/
insert into typefichier(libelleTypeFichier) values('Texte');
insert into typefichier(libelleTypeFichier) values('Vidéo');
insert into typefichier(libelleTypeFichier) values('Audio');
insert into typefichier(libelleTypeFichier) values('Image');


/*==============================================================*/
/* Table: FORMATFICHIER                                */
/*==============================================================*/
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (1, '.txt');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (2, '.avi');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (2, '.wmv');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (2, '.mkv');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (3, '.wav');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (3, '.mp3');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (3, '.wma');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (4, '.bmp');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (4, '.tiff');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (4, '.jpeg');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (4, '.gif');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (4, '.png');
/*==============================================================*/
/* Table: FORMATFICHIER                                */
/*==============================================================*/
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (1, '.txt');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (2, '.avi');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (2, '.wmv');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (2, '.mkv');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (3, '.wav');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (3, '.mp3');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (3, '.wma');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (4, '.bmp');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (4, '.tiff');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (4, '.jpeg');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (4, '.gif');
insert into formatfichier(IDTYPEFICHIER, CODEFORMAT) values (4, '.png');

/*==============================================================*/
/* Table: FICHIER - Création d'un fichier ROOT                           */
/*==============================================================*/
insert into fichier(libelleUserFichier,
                libelleTechniqueFichier,
                tailleFichier,
                estUnDossier, 
                FIC_IDFICHIER,
                IDUTILISATEUR, 
                IDFORMAT)
values('ROOT', 'root', 0, true, null, 1, null);

/*==============================================================*/
/* Table: FICHIER - Création d'un fichier de type texte Ã  la racine                            */
/*==============================================================*/
insert into fichier(libelleUserFichier,
                libelleTechniqueFichier,
                tailleFichier,
                estUnDossier, 
                FIC_IDFICHIER,
                IDUTILISATEUR, 
                IDFORMAT)
values('Fichier1', 'fichier1', 630000000, false, 1, 1, 1);


/*==============================================================*/
/* Table: FORMATFICHIER                                */
/*==============================================================*/

/*
Création d'un dossier
*/
insert into fichier(libelleUserFichier,
                libelleTechniqueFichier,
                tailleFichier,
                estUnDossier, 
                FIC_IDFICHIER,
                IDUTILISATEUR, 
                IDFORMAT)
values('Folder1', 'folder1', 0, true, 1, 1, null);

/*
Création d'un fichier de type vidéo dans un dossier
*/
insert into fichier(libelleUserFichier,
                    libelleTechniqueFichier,
                    tailleFichier,
                    estUnDossier, 
                    FIC_IDFICHIER,
                    IDUTILISATEUR, 
                    IDFORMAT)
values('Fichier2', 'fichier2', 4500000, false, 3, 1, 2);
    
/*
Création d'un fichier de type audio dans un dossier
*/
insert into fichier(libelleUserFichier,
                    libelleTechniqueFichier,
                    tailleFichier,
                    estUnDossier, 
                    FIC_IDFICHIER,
                    IDUTILISATEUR, 
                    IDFORMAT)
values('Fichier3', 'fichier3', 65000000, false, 3, 1, 3);
    
/*
Création d'un fichier de type image dans un dossier
*/
insert into fichier(libelleUserFichier,
                    libelleTechniqueFichier,
                    tailleFichier,
                    estUnDossier, 
                    FIC_IDFICHIER,
                    IDUTILISATEUR, 
                    IDFORMAT)
values('Fichier4', 'fichier4', 72000000, false, 3, 1, 4);
    
insert into facture(dateFacture,
					consoStockageFacture,
					consoOperationFacture,
					consoFluxFacture,
					idutilisateur,
					idtarification)
values('31/05/2018', 560000, 12, 235600, 1, 1);

	
/*==============================================================*/
/* TEST TRIGGER                             */
/*==============================================================*/
/*
insert into tarificationsupplement (idsupplement, idtarification)
values(3,1);
*/
/*
Création d'un fichier dans un autre fichier
*/
/*
insert into fichier(libelleUserFichier,
                    libelleTechniqueFichier,
                    tailleFichier,
                    estUnDossier, 
                    FIC_IDFICHIER,
                    IDUTILISATEUR, 
                    IDFORMAT)
values('Fichier3', 'fichier3', 5000000, false, 1, 1, null);
*/
