#!/bin/bash
echo "start generate string_r.xml"
file_name="string_r.xml";

echo "<?xml version=\"1.0\" encoding=\"utf-8\"?>" >> $file_name;
echo "<resources>" >> $file_name;

for((i=1;i<=65;i++));
do
  echo "<string name=\"public_r_$i\">TEST-$i</string>" >> $file_name;
done

echo "</resources>" >> $file_name;
echo "generate string_r.xml success!";