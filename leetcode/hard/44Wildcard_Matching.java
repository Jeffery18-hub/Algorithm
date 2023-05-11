class Solution{
    boolean isMatch(String s, String p){
	int i= 0;
	int j= 0;
	int star_i =-1;
	int star_j =-1;
	int m= s.length();
	int n= p.length();

	while(i<m){
	    if(j<n &&(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){
		++i;
		++j;
	    }
	    else if(j<n && p.charAt(j)=='*') {
		star_i = i;
		star_j = j;
		++j;
	    }
	    else if(star_i>-1){
		i= ++star_i;
		j= star_j+1;
	    }
	    else{
		return false;
	    }
	}

	while(j<n && p.charAt(j)=='*')++j;

	return j==n;
    }
}
