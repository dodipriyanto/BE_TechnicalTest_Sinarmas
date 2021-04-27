#!/bin/bash

#EXMAPLE TO RUN
# bash unfulfilledOrders.sh orderLists.txt "STRAWBERRY SHORTCAKE" 2019-01-18

orderList=$(cat $1)
customerOrder="$2"
orderDate="$3"


SAVEIFS=$IFS
IFS=$'\n'
orderList=($orderList)
IFS=$SAVEIFS

max=3
row=0
newArray=()


#SCRIPT FOR FILTER ORDER LIST
for i in "${orderList[@]}"
do
  if [[ "${i^^}" == *"${customerOrder^^}"* && "${i^^}" == *"FALSE"* && "${i^^}" == *"$orderDate"* ]] ; then
    ##save filtered array to new array as newArray variable
    newArray+=("$i"$'\n')
  fi

done

#SCRIPT FOR SORT orderList as newArray
IFS=$'\n' sorted=($(sort <<<"${newArray[@]}"))
unset IFS

#SHOW ARRAY WITH LIMIT
for i in "${sorted[@]}"
do
  if [ $row -lt $max ]; then
        echo "$i"
  fi
  row=$((row + 1))
done
