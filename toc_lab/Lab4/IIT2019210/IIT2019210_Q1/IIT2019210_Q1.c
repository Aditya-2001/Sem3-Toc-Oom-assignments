#include<stdio.h>
#include<string.h>
int i,j,k,l,m,n=0,o,p,nv,z=0,t,x=0,q;
char str[1000],temp[2000],temp2[2000],temp3[2000];
//global variables
//str will be used to store string passed by user
//temp is used for a try to make the original using defined productions
//temp2 and temp3 are used to for swapping and storing purposes

struct prod
{
    char lhs[1000],rhs[1000][1000];
    int n;
}pro[1000];
//Structure is defined so that when ever we have two or more productions for a single terminal we can combine it to put into one structural element
//Example for S -> aSa and S -> c will lead to n=, lhs[0] and lhs[1] will be S, rhs[0]=aSa and rhs[1]=c, it will be easy to handle productions.


void nextstring();
//This is function declaration and its body in below main and is explained there.

int main()
{
    FILE *f;			//file pointer

    for(i=0;i<1000;i++)
        pro[i].n=0;		//Assumption is that initially there is no productions so all values are initialiazed by 1.

    f=fopen("test.txt","r");
    if(f==NULL)					//If file does not exists then we have to exit from the code.
    {
    	printf("No such file exists\n");
    	return -1;
	}
    while(!feof(f))								//This while loop results that the grammar is successfully read from text file.
    {
        fscanf(f,"%s",pro[n].lhs);
        if(n>0)
        {
            if( strcmp(pro[n].lhs,pro[n-1].lhs) == 0 )
            {
                pro[n].lhs[0]='\0';
                fscanf(f,"%s",pro[n-1].rhs[pro[n-1].n]);
                pro[n-1].n++;
                continue;
            }
        }
        fscanf(f,"%s",pro[n].rhs[pro[n].n]);
        pro[n].n++;
        n++;
    }

    printf("THE GRAMMAR IS AS FOLLOWS:\n");
    int max=pro[0].n;						//max variable is important in this code.
    for(i=0;i<n;i++)						//This for loop will print the grammar which is read from the file
    {
    	if(max<pro[i].n)
		max=pro[i].n;	
        for(j=0;j<pro[i].n;j++)
            printf("%s -> %s\n",pro[i].lhs,pro[i].rhs[j]);
    }										//max is variable which tells that out of all productions what is maximum no of productions with same lhs.		
			
    while(1)
    {
        for(l=0;l<1000;l++)
            str[0]='0';

        printf("\nEnter test string ( press 0 to exit ) : ");
        scanf("%s",str);					//Test string is stored in a character array str
        if(str[0]=='0')
            return 1;
        int rotate=0;						//This rotate variable is associated with max variable
        int flag=0;							//variable to stop the loop
    	printf("Productions:  ");
		while((++rotate)<=max && flag==0){	//Basically this is the condition where until all the conditions are checked, loop will not break or until flag is valid.
		for(j=0;j<pro[0].n;j++)
        {
            for(l=0;l<2000;l++)
                temp[l]='0';
            strcpy(temp,pro[0].rhs[j]);		//For jth productions of start variable its rhs is copied to character array temp

            m=0;
            for(i=0;i<strlen(str);i++)
            {	
            	if(i==0)
            		printf("%s ",temp);
                if(str[i]==temp[i])			//If ith character of passed string and ith character of rhs array is equal then move to next character 
                    m++;
                else if(str[i]!=temp[i] && temp[i]>=65 && temp[i]<=90)	//If ith character of rhs array is uppercase then call the function nextstring.
                {
                    nextstring();
                    if(str[i]==temp[i])
                        m++;
            		printf("--> %s ",temp);
                }
                else if( str[i]!=temp[i] && (temp[i]<65 || temp[i]>90) )	//If both above cases fail then string can't be parsed
                    break;
            }
			if(m==strlen(str) && strlen(str)==strlen(temp))			//Condition of parsing
            {
                printf(" :: Parsing Passed\nThis string exists in the grammar\n");
                flag=1;
                break;
            }
            if(flag==0){
            	printf(" :: Parsing Failed\n");
			}
        }
		int w;
        if(j==pro[0].n)					//If string is not parsed then all the lhs with multiple productions are being rotated anticlockwise.
        {	
        	char abcd[1000];
        	for(i=0;i<n;i++)
        		if(pro[i].n>1){
        			for(w=0;w<1000;w++)
        				abcd[w]=pro[i].rhs[0][w];
        			for(w=1;w<pro[i].n;w++){
        				for(q=0;q<1000;q++)
        					pro[i].rhs[w-1][q]=pro[i].rhs[w][q];
					}
					for(w=0;w<1000;w++){
        				pro[i].rhs[pro[i].n-1][w]=abcd[w];}
				}

		}								//For more complex strings this rotation is to be done to make each and every possible combination.
	}
	if(j==pro[0].n)						//Condition when string can not be parsed.
        printf("\nThis string does not exists in the grammar\n");
	}

    getchar();
}

void nextstring()				//Function to find the next string
{
    for(k=0;k<n;k++)
    {
        if(temp[i]==pro[k].lhs[0])		//Condition to check the what is the next state
        {
            for(l=0;l<2000;l++)
            	temp3[l]=temp[l];		//Copied temp to temp3
			for(t=0;t<pro[k].n;t++)
            {
            	for(l=0;l<2000;l++)
            		temp[l]=temp3[l];	//Copied temp3 to temp
                for(l=0;l<2000;l++)
                    temp2[l]='\0';		//We we emptying temp2
                for(l=i+1;l<strlen(temp);l++)
                    temp2[l-i-1]=temp[l];		//string after interupt is stored in temp2
                for(l=i;l<2000;l++)
                    temp[l]='\0';
                for(l=0;l<strlen(pro[k].rhs[t]);l++)
                    temp[i+l]=pro[k].rhs[t][l];		//At interupt new string is stored
                strcat(temp,temp2);					//temp is concatenated with previous string, eg aSa -> aS,a -> aaSa,a -> aaSaa and much more
                if(str[i]==temp[i])
                    return;							//If we find our character return to main function
                else if(str[i]!=temp[i] && temp[i]>=65 && temp[i]<=90)		//Tf its a uppercase character break the loop
                    break;
            }
            break;
        }
    }
    if(temp[i]>=65 && temp[i]<=90)			//If its uppercase character the call again the nextstring function to extend the string
        nextstring();
}
