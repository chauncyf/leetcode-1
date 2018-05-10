class excelTitleToNumber{

	public int titleToNumber(String s) {
        char[] array = s.toCharArray();
        int count = 0;
        for(int i = 0; i < array.length; i++){
            count = count*26 + (array[i]-64);
        }
        return count;
    }
    
}

