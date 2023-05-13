// double pointers
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

// dynamic programming

class Solution{
    boolean isMatch(String s, String p){
	int m = s.length();
	int n = p.length();

	//定义二维数组，int array; init with value false
	boolean[][] dp = new boolean[m+1][n+1];
	
	// 边界
	dp[0][0]= true;

	// s is empty and p string contains one or multi "*"
	for(int i = 1; i<= n; ++i){
	    if( p.charAt(i-1) == '*'){
		dp[0][i]= dp[0][i-1];
	    }
	}

	// 状态转移方程
	for(int i=1; i <=m; ++i){
	    for(int j=1; j<=n; ++j){
		if(p.charAt(j-1) == '*'){
		    dp[i][j] = dp[i-1][j] || dp[i][j-1];
		}
		else{
		    dp[i][j] = dp[i-1][j-1] && ( s.charAt(i-1)==p.charAt(j-1)  || p.charAt(j-1)== '?'); 
		}	
	    }
	}

	return dp[m][n];
    }
}

