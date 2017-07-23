import { TeamClientPage } from './app.po';

describe('team-client App', () => {
  let page: TeamClientPage;

  beforeEach(() => {
    page = new TeamClientPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
