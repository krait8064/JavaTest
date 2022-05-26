res=''
for i in $(seq 1 6)  
do   
res=$res${RANDOM:0-1}
done
echo $res
