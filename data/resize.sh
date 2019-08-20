for bild in $(ls)
do convert $bild -resize 120x120 /home/kat/Documents/studium/new_$bild
echo $bild is done
done

for bild in $(/home/kat/Documents/studium)
do identify $bild
done
