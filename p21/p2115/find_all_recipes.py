from typing import List


class Solution:
    def findAllRecipes(self, recipes: List[str], ingredients: List[List[str]], supplies: List[str]) -> List[str]:
        supplies_set = set()
        for supply in supplies:
            supplies_set.add(supply)

        result = []
        visited = set()

        updated = True
        while updated:
            updated = False
            for i in range(len(recipes)):
                flag = False
                if recipes[i] not in visited:
                    flag = True
                    for ingredient in ingredients[i]:
                        if ingredient not in supplies_set:
                            flag = False
                            break

                if flag:
                    supplies_set.add(recipes[i])
                    result.append(recipes[i])
                    visited.add(recipes[i])
                    updated = True

        return result


if __name__ == '__main__':
    obj = Solution()
    recipes = ["bread"]
    ingredients = [["yeast", "flour"]]
    supplies = ["yeast", "flour", "corn"]
    print(obj.findAllRecipes(recipes,ingredients,supplies))
