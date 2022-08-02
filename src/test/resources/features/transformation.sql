SELECT *
    FROM "CLIENT" WHERE "ID" NOT IN (
        SELECT "CLIENT"."ID"
        FROM "CLIENT"
        WHERE "CLIENT"."Nom"
            MATCH (
                SELECT "SOURCE" FROM "MAPPING" WHERE "CHAMP" = 'Nom'
            )
        AND "CLIENT"."Prenom"
            MATCH (
                SELECT "SOURCE" FROM "MAPPING" WHERE "CHAMP" = 'Prenom'
            )
        AND "CLIENT"."DateNaissance"
            MATCH (
                SELECT "SOURCE" FROM "MAPPING" WHERE "CHAMP" = 'DateNaissance'
            )
    )