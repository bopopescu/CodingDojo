import { ThePowerLevelsPage } from './app.po';

describe('the-power-levels App', () => {
  let page: ThePowerLevelsPage;

  beforeEach(() => {
    page = new ThePowerLevelsPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
