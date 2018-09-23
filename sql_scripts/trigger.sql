/*
Contrainte: check si typeSupplement n'est pas déjà renseigné pour cette tarification
*/
create or replace function check_Tarification_Type_Supplement() returns trigger
language 'plpgsql'
as $t$
	begin 
		IF (
				select count(ts.idSupplement)
				from TarificationSupplement ts
				inner join supplement s on ts.idSupplement = s.idSupplement
				inner join typeSupplement ty on ty.idTypeSupplement = s.idTypeSupplement
				where 
					ts.idTarification = new.idTarification
					and ty.idtypeSupplement = (
							select ty2.idTypeSupplement 
							from supplement s2
							inner join typeSupplement ty2 on s2.idSupplement = ty2.idTypeSupplement
							where s2.idSupplement = new.idSupplement
						)
			) > 0 THEN
      RAISE EXCEPTION 'Erreur : Une tarification existe deja avec ce type de supplement';
   END IF;
   RETURN NEW;
	end;
$t$;

create trigger tg_check_Tarification_Type_Supplement
before insert on tarificationSupplement for each row
execute procedure check_Tarification_Type_Supplement();


/* --------------------------------------------------------------------- */

/*
Trigger avant l'insertion dans la table Fichier. On vérifie si le champ Fic_idFichier est vide, si non alors on vérifie
que l'id du fichier correspondant est un dossier.
*/
CREATE OR REPLACE FUNCTION checkFile() RETURNS TRIGGER LANGUAGE 'plpgsql' 
	AS $checkFile$
		DECLARE
			isFolder boolean;
        BEGIN
			IF new.Fic_idFichier is not null THEN
				select estUnDossier into isFolder from Fichier
				where idFichier = new.Fic_idFichier;
				
				IF isFolder = false THEN
					RAISE EXCEPTION 'Erreur : Le fichier doit être de type dossier';
				END IF;
			END IF;
            return new;
        END;
    $checkFile$;

	
	
CREATE TRIGGER triggerCheckFile
BEFORE INSERT OR UPDATE ON Fichier
FOR EACH ROW
EXECUTE PROCEDURE checkFile();