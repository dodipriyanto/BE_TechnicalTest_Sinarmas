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


for i in "${orderList[@]}"
do
  if [[ "${i^^}" == *"${customerOrder^^}"* && "${i^^}" == *"FALSE"* ]] ; then
    if [ $row -le $max ]; then
        echo "$i"
    fi
  fi
  row=$((row + 1))
done


