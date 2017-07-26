import { GitHubClientPage } from './app.po';

describe('git-hub-client App', () => {
  let page: GitHubClientPage;

  beforeEach(() => {
    page = new GitHubClientPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
