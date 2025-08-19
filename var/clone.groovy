def call(String url, branch)
{
  echo "This is cloning the code"
  git url: "${url}", branch: "${branch}"
  echo "Code Cloning successfull"
}
