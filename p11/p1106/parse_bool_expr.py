class Solution:
    """
    Oct 19, 2024 23:40
    Time Complexity: O(n)
    Space Complexity: O(n)
    """
    def parseBoolExpr(self, expression: str) -> bool:
        if expression[0] == 't':
            return True
        elif expression[0] == 'f':
            return False
        elif expression[0] == '!':
            return not self.parseBoolExpr(expression[2:-1])
        elif expression[0] == '&':
            return self.logical_and(expression[2:-1])
        elif expression[0] == '|':
            return self.logical_or(expression[2:-1])

        return False

    def logical_and(self, expression):
        sub_expressions = self.split_expression(expression)
        for sub_expression in sub_expressions:
            if not self.parseBoolExpr(sub_expression):
                return False
        return True

    def logical_or(self, expression):
        sub_expressions = self.split_expression(expression)
        for sub_expression in sub_expressions:
            if self.parseBoolExpr(sub_expression):
                return True
        return False

    def split_expression(self, expression):
        depth = 0
        result = []
        sub_expression = ""
        for char in expression:
            sub_expression += char
            if char == '(':
                depth += 1
            elif char == ')':
                depth -= 1
            elif depth == 0 and char == ',':
                result.append(sub_expression[0:-1])
                sub_expression = ""

        result.append(sub_expression)
        return result


if __name__ == '__main__':
    s = Solution()
    print(s.parseBoolExpr("&(|(f))") == False)
