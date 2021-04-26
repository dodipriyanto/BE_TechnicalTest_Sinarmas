#!/bin/bash

#EXMAPLE TO RUN
# bash recipeChecker.sh fruitList.txt "apple pie"

fruitList=$(cat $1)
order="$2"
fruitListArray=($(echo $fruitList | tr "," "\n"))

MENU=("APPLE PIE" "PINAPPLE PIE" "FRUIT PARFAIT")
appleIn=0
pinappleIn=0

#CHECK APPLE PIE
if [ "${order^^}" == "${MENU[0]}" ]; then
  for i in "${fruitListArray[@]}"; do
    if [ ${i^^} == "APPLE" ]; then
      appleIn=$((appleIn + 1))
    fi
  done

  if [ $appleIn -gt 2 ]; then
    echo "You shall have ${order^^}!"
  else
    echo "You shall not have ${order^^}!"
  fi
fi

#CHECK PINAPPLE PIE
if [ "${order^^}" == "${MENU[1]}" ]; then
  for i in "${fruitListArray[@]}"; do
    if [ ${i^^} == "PINAPPLE" ]; then
      pinappleIn=$((pinappleIn + 1))
    fi
  done

  if [ $pinappleIn -gt 2 ]; then
    echo "You shall have ${order^^}!"
  else
    echo "You shall not have ${order^^}!"
  fi
fi

#CHECK FRUIT PARFAIT
if [ "${order^^}" == "${MENU[2]}" ]; then
  for i in "${fruitListArray[@]}"; do
    if [ ${i^^} == "APPLE" ]; then
      appleIn=$((appleIn + 1))
    fi

    if [ ${i^^} == "PINAPPLE" ]; then
      pinappleIn=$((pinappleIn + 1))
    fi
  done

  if [[ $appleIn -gt 2 && $pinappleIn -gt 2 ]]; then
    echo "You shall have ${order^^}!"
  else
    echo "You shall not have ${order^^}!"
  fi
fi

#CHECK MENU NOT EXIST
if [[ "${order^^}" != "${MENU[0]}" && "${order^^}" != "${MENU[1]}" && "${order^^}" != "${MENU[2]}" ]]; then
  echo "We do not have that on the menu"
fi


