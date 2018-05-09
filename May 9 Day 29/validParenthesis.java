class validParenthesis{
	
	public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{') stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                if(isCouple(stack.peek(), c)) stack.pop();
                else return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
        
    }
    
    public boolean isCouple(char a, char b){
        
        if(a == '[' && b == ']' || a=='(' && b == ')' || a == '{' && b == '}') return true;
        return false;
        
    }

}