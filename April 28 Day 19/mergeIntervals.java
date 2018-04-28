class mergeIntervals{

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                int i1 = o1.start;
                int i2 = o2.start;
                if(i1 > i2)  return 1;
                if(i1 < i2)  return -1;
                return 0;
            }
        });
        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start <= end)
            //这里一定要取最大值，因为后一个的end未必比前一个的大
                end = Math.max(intervals.get(i).end, end);
            else{
                result.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        //这里一定要注意加上最后一个！
        result.add(new Interval(start, end));
        return result;
    }

}

    