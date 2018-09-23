/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     17/04/2018 11:19:20                          */
/*==============================================================*/


drop index if exists FACTURETARIFICATION_FK cascade;

drop index if exists USERFACTURE_FK cascade;

drop index if exists FACTURE_PK cascade;

drop table if exists FACTURE cascade;

drop index if exists STRUCTURE_FK cascade;

drop index if exists USERFICHIER_FK cascade;

drop index if exists FICHIERFORMAT_FK cascade;

drop index if exists FICHIER_PK cascade;

drop table if exists FICHIER cascade;

drop index if exists FORFAIT_PK cascade;

drop table if exists FORFAIT cascade;

drop index if exists FORMATTYPEFICHIER_FK cascade;

drop index if exists FORMATFICHIER_PK cascade;

drop table if exists FORMATFICHIER cascade;

drop index if exists PARTAGE2_FK cascade;

drop index if exists PARTAGE_FK cascade;

drop index if exists PARTAGE_PK cascade;

drop table if exists PARTAGE cascade;

drop index if exists SUPPLEMENTTYPESUPPLEMENT_FK cascade;

drop index if exists SUPPLEMENT_PK cascade;

drop table if exists SUPPLEMENT cascade;

drop index if exists FORFAITTARIFICATION_FK cascade;

drop index if exists TARIFICATION_PK cascade;

drop table if exists TARIFICATION cascade;

drop index if exists TARIFICATIONSUPPLEMENT2_FK cascade;

drop index if exists TARIFICATIONSUPPLEMENT_FK cascade;

drop index if exists TARIFICATIONSUPPLEMENT_PK cascade;

drop table if exists TARIFICATIONSUPPLEMENT cascade;

drop index if exists TYPEFICHIER_PK cascade;

drop table if exists TYPEFICHIER cascade;

drop index if exists TYPESUPPLEMENT_PK cascade;

drop table if exists TYPESUPPLEMENT;

drop index if exists USERFORFAIT_FK;

drop index if exists UTILISATEUR_PK;

drop table if exists UTILISATEUR;

/*==============================================================*/
/* Table: FACTURE                                               */
/*==============================================================*/
create table FACTURE (
   IDFACTURE            SERIAL               not null,
   IDUTILISATEUR        INT4                 not null,
   IDTARIFICATION       INT4                 not null,
   DATEFACTURE          DATE                 null,
   CONSOSTOCKAGEFACTURE INT8                 not null,
   CONSOOPERATIONFACTURE INT4                 not null,
   CONSOFLUXFACTURE     INT8                 not null,
   constraint PK_FACTURE primary key (IDFACTURE)
);

/*==============================================================*/
/* Index: FACTURE_PK                                            */
/*==============================================================*/
create unique index FACTURE_PK on FACTURE (
IDFACTURE
);

/*==============================================================*/
/* Index: USERFACTURE_FK                                        */
/*==============================================================*/
create  index USERFACTURE_FK on FACTURE (
IDUTILISATEUR
);

/*==============================================================*/
/* Index: FACTURETARIFICATION_FK                                */
/*==============================================================*/
create  index FACTURETARIFICATION_FK on FACTURE (
IDTARIFICATION
);

/*==============================================================*/
/* Table: FICHIER                                               */
/*==============================================================*/
create table FICHIER (
   IDFICHIER            SERIAL               not null,
   FIC_IDFICHIER        INT4                 null,
   IDUTILISATEUR        INT4                 not null,
   IDFORMAT             INT4                 ,
   LIBELLEUSERFICHIER   VARCHAR(256)         not null,
   LIBELLETECHNIQUEFICHIER VARCHAR(256)         not null,
   TAILLEFICHIER        INT8                 not null,
   ESTUNDOSSIER         BOOL                 not null,
   constraint PK_FICHIER primary key (IDFICHIER)
);

/*==============================================================*/
/* Index: FICHIER_PK                                            */
/*==============================================================*/
create unique index FICHIER_PK on FICHIER (
IDFICHIER
);

/*==============================================================*/
/* Index: FICHIERFORMAT_FK                                      */
/*==============================================================*/
create  index FICHIERFORMAT_FK on FICHIER (
IDFORMAT
);

/*==============================================================*/
/* Index: USERFICHIER_FK                                        */
/*==============================================================*/
create  index USERFICHIER_FK on FICHIER (
IDUTILISATEUR
);

/*==============================================================*/
/* Index: STRUCTURE_FK                                          */
/*==============================================================*/
create  index STRUCTURE_FK on FICHIER (
FIC_IDFICHIER
);

/*==============================================================*/
/* Table: FORFAIT                                               */
/*==============================================================*/
create table FORFAIT (
   IDFORFAIT            SERIAL               not null,
   LIBELLEFORFAIT       VARCHAR(60)          not null,
   constraint PK_FORFAIT primary key (IDFORFAIT)
);

/*==============================================================*/
/* Index: FORFAIT_PK                                            */
/*==============================================================*/
create unique index FORFAIT_PK on FORFAIT (
IDFORFAIT
);

/*==============================================================*/
/* Table: FORMATFICHIER                                         */
/*==============================================================*/
create table FORMATFICHIER (
   IDFORMAT             SERIAL               not null,
   IDTYPEFICHIER        INT4                 not null,
   CODEFORMAT           VARCHAR(10)          not null,
   constraint PK_FORMATFICHIER primary key (IDFORMAT)
);

/*==============================================================*/
/* Index: FORMATFICHIER_PK                                      */
/*==============================================================*/
create unique index FORMATFICHIER_PK on FORMATFICHIER (
IDFORMAT
);

/*==============================================================*/
/* Index: FORMATTYPEFICHIER_FK                                  */
/*==============================================================*/
create  index FORMATTYPEFICHIER_FK on FORMATFICHIER (
IDTYPEFICHIER
);

/*==============================================================*/
/* Table: PARTAGE                                               */
/*==============================================================*/
create table PARTAGE (
   IDUTILISATEUR        INT4                 not null,
   IDFICHIER            INT4                 not null,
   constraint PK_PARTAGE primary key (IDUTILISATEUR, IDFICHIER)
);

/*==============================================================*/
/* Index: PARTAGE_PK                                            */
/*==============================================================*/
create unique index PARTAGE_PK on PARTAGE (
IDUTILISATEUR,
IDFICHIER
);

/*==============================================================*/
/* Index: PARTAGE_FK                                            */
/*==============================================================*/
create  index PARTAGE_FK on PARTAGE (
IDUTILISATEUR
);

/*==============================================================*/
/* Index: PARTAGE2_FK                                           */
/*==============================================================*/
create  index PARTAGE2_FK on PARTAGE (
IDFICHIER
);

/*==============================================================*/
/* Table: SUPPLEMENT                                            */
/*==============================================================*/
create table SUPPLEMENT (
   IDSUPPLEMENT         SERIAL               not null,
   IDTYPESUPPLEMENT     INT4                 not null,
   TRANCHESUPPLEMENT    INT8                 null,
   TARIFSUPPLEMENT      NUMERIC(5,2)         null,
   constraint PK_SUPPLEMENT primary key (IDSUPPLEMENT)
);

/*==============================================================*/
/* Index: SUPPLEMENT_PK                                         */
/*==============================================================*/
create unique index SUPPLEMENT_PK on SUPPLEMENT (
IDSUPPLEMENT
);

/*==============================================================*/
/* Index: SUPPLEMENTTYPESUPPLEMENT_FK                           */
/*==============================================================*/
create  index SUPPLEMENTTYPESUPPLEMENT_FK on SUPPLEMENT (
IDTYPESUPPLEMENT
);

/*==============================================================*/
/* Table: TARIFICATION                                          */
/*==============================================================*/
create table TARIFICATION (
   IDTARIFICATION       SERIAL               not null,
   IDFORFAIT            INT4                 not null,
   TARIFTARIFICATION    NUMERIC(5,2)         not null,
   STOCKAGETARIFICATION INT8                 null,
   NBOPERATIONSTARIFICATION INT4                 null,
   FLUXTARIFICATION     INT8                 null,
   ACTIVETARIFICATION   BOOL                 null,
   constraint PK_TARIFICATION primary key (IDTARIFICATION)
);

/*==============================================================*/
/* Index: TARIFICATION_PK                                       */
/*==============================================================*/
create unique index TARIFICATION_PK on TARIFICATION (
IDTARIFICATION
);

/*==============================================================*/
/* Index: FORFAITTARIFICATION_FK                                */
/*==============================================================*/
create  index FORFAITTARIFICATION_FK on TARIFICATION (
IDFORFAIT
);

/*==============================================================*/
/* Table: TARIFICATIONSUPPLEMENT                                */
/*==============================================================*/
create table TARIFICATIONSUPPLEMENT (
   IDTARIFICATION       INT4                 not null,
   IDSUPPLEMENT         INT4                 not null,
   constraint PK_TARIFICATIONSUPPLEMENT primary key (IDTARIFICATION, IDSUPPLEMENT)
);

/*==============================================================*/
/* Index: TARIFICATIONSUPPLEMENT_PK                             */
/*==============================================================*/
create unique index TARIFICATIONSUPPLEMENT_PK on TARIFICATIONSUPPLEMENT (
IDTARIFICATION,
IDSUPPLEMENT
);

/*==============================================================*/
/* Index: TARIFICATIONSUPPLEMENT_FK                             */
/*==============================================================*/
create  index TARIFICATIONSUPPLEMENT_FK on TARIFICATIONSUPPLEMENT (
IDTARIFICATION
);

/*==============================================================*/
/* Index: TARIFICATIONSUPPLEMENT2_FK                            */
/*==============================================================*/
create  index TARIFICATIONSUPPLEMENT2_FK on TARIFICATIONSUPPLEMENT (
IDSUPPLEMENT
);

/*==============================================================*/
/* Table: TYPEFICHIER                                           */
/*==============================================================*/
create table TYPEFICHIER (
   IDTYPEFICHIER        SERIAL               not null,
   LIBELLETYPEFICHIER   VARCHAR(60)          not null,
   constraint PK_TYPEFICHIER primary key (IDTYPEFICHIER)
);

comment on table TYPEFICHIER is
'VALUES:
- audio
- video
- image';

/*==============================================================*/
/* Index: TYPEFICHIER_PK                                        */
/*==============================================================*/
create unique index TYPEFICHIER_PK on TYPEFICHIER (
IDTYPEFICHIER
);

/*==============================================================*/
/* Table: TYPESUPPLEMENT                                        */
/*==============================================================*/
create table TYPESUPPLEMENT (
   IDTYPESUPPLEMENT     SERIAL               not null,
   LIBELLESUPPLEMENT    VARCHAR(60)          not null,
   constraint PK_TYPESUPPLEMENT primary key (IDTYPESUPPLEMENT)
);

/*==============================================================*/
/* Index: TYPESUPPLEMENT_PK                                     */
/*==============================================================*/
create unique index TYPESUPPLEMENT_PK on TYPESUPPLEMENT (
IDTYPESUPPLEMENT
);

/*==============================================================*/
/* Table: UTILISATEUR                                           */
/*==============================================================*/
create table UTILISATEUR (
   IDUTILISATEUR        SERIAL               not null,
   IDFORFAIT            INT4                 not null,
   LOGINUTILISATEUR     VARCHAR(60)          not null	unique,
   MDPUTILISATEUR       CHAR(128)            not null,
   NOMUTILISATEUR		VARCHAR(40)			 not null,
   PRENOMUTILISATEUR	VARCHAR(40)			 not null,
   constraint PK_UTILISATEUR primary key (IDUTILISATEUR)
);

/*==============================================================*/
/* Index: UTILISATEUR_PK                                        */
/*==============================================================*/
create unique index UTILISATEUR_PK on UTILISATEUR (
IDUTILISATEUR
);

/*==============================================================*/
/* Index: USERFORFAIT_FK                                        */
/*==============================================================*/
create  index USERFORFAIT_FK on UTILISATEUR (
IDFORFAIT
);

alter table FACTURE
   add constraint FK_FACTURE_FACTURETA_TARIFICA foreign key (IDTARIFICATION)
      references TARIFICATION (IDTARIFICATION)
      on delete restrict on update restrict;

alter table FACTURE
   add constraint FK_FACTURE_USERFACTU_UTILISAT foreign key (IDUTILISATEUR)
      references UTILISATEUR (IDUTILISATEUR)
      on delete restrict on update restrict;

alter table FICHIER
   add constraint FK_FICHIER_FICHIERFO_FORMATFI foreign key (IDFORMAT)
      references FORMATFICHIER (IDFORMAT)
      on delete restrict on update restrict;

alter table FICHIER
   add constraint FK_FICHIER_STRUCTURE_FICHIER foreign key (FIC_IDFICHIER)
      references FICHIER (IDFICHIER)
      on delete restrict on update restrict;

alter table FICHIER
   add constraint FK_FICHIER_USERFICHI_UTILISAT foreign key (IDUTILISATEUR)
      references UTILISATEUR (IDUTILISATEUR)
      on delete restrict on update restrict;

alter table FORMATFICHIER
   add constraint FK_FORMATFI_FORMATTYP_TYPEFICH foreign key (IDTYPEFICHIER)
      references TYPEFICHIER (IDTYPEFICHIER)
      on delete restrict on update restrict;

alter table PARTAGE
   add constraint FK_PARTAGE_PARTAGE_UTILISAT foreign key (IDUTILISATEUR)
      references UTILISATEUR (IDUTILISATEUR)
      on delete restrict on update restrict;

alter table PARTAGE
   add constraint FK_PARTAGE_PARTAGE2_FICHIER foreign key (IDFICHIER)
      references FICHIER (IDFICHIER)
      on delete restrict on update restrict;

alter table SUPPLEMENT
   add constraint FK_SUPPLEME_SUPPLEMEN_TYPESUPP foreign key (IDTYPESUPPLEMENT)
      references TYPESUPPLEMENT (IDTYPESUPPLEMENT)
      on delete restrict on update restrict;

alter table TARIFICATION
   add constraint FK_TARIFICA_FORFAITTA_FORFAIT foreign key (IDFORFAIT)
      references FORFAIT (IDFORFAIT)
      on delete restrict on update restrict;

alter table TARIFICATIONSUPPLEMENT
   add constraint FK_TARIFICA_TARIFICAT_TARIFICA foreign key (IDTARIFICATION)
      references TARIFICATION (IDTARIFICATION)
      on delete restrict on update restrict;

alter table TARIFICATIONSUPPLEMENT
   add constraint FK_TARIFICA_TARIFICAT_SUPPLEME foreign key (IDSUPPLEMENT)
      references SUPPLEMENT (IDSUPPLEMENT)
      on delete restrict on update restrict;

alter table UTILISATEUR
   add constraint FK_UTILISAT_USERFORFA_FORFAIT foreign key (IDFORFAIT)
      references FORFAIT (IDFORFAIT)
      on delete restrict on update restrict;

