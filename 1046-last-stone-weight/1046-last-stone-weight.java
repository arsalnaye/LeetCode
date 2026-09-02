class Solution {
    public int lastStoneWeight(int[] stones) {
        //list -> stones
        //condition: list.size>1
        //sort
        //find m1,m2
        //if(m1==m2)
        //list.add(m1-m2)
        //list.size==0?0:return 0
        List<Integer> list=new ArrayList<>();
        for(int stone:stones){
            list.add(stone);
        }while(list.size()>1){
            Collections.sort(list);
            int stone1=list.remove(list.size()-1);
            int stone2=list.remove(list.size()-1);
            if(stone1==stone2){
                continue;
            }list.add(stone1-stone2);
        }return list.size()==0?0:list.get(0);
    }
}